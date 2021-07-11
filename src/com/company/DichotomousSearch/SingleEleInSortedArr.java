package com.company.DichotomousSearch;

/**
 * @Author ChanZany
 * @Date 2021/7/3 17:16
 * @Version 1.0
 */
public class SingleEleInSortedArr {
    //log2n的复杂度->二分
    //如何减少搜索范围：
    //当去掉mid及其相同的元素，哪边元素个数为奇数则说明目标值在哪边
    public int singleNonDuplicate(int[] nums) {
        int mid, l = 0, r = nums.length - 1;
        if(nums.length%2 == 0) return -1;
        if (nums.length == 1) return nums[0];
        while(l<r){
            mid = (l+r)/2;
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]){
                return nums[mid];
            }else if(nums[mid]==nums[mid + 1]){
                if((r-mid-1) % 2!=0){   //在右区间
                    l = mid + 2;
                }else{
                    r = mid - 1;
                }
            }else if(nums[mid]==nums[mid -1]){
                if((mid-1-l)%2!=0){     //在左区间
                    r = mid - 2;
                }else{
                    l = mid + 1;
                }
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(new SingleEleInSortedArr().singleNonDuplicate(nums));
    }
}
