package com.company.DichotomousSearch;

/**
 * @Author ChanZany
 * @Date 2021/7/3 16:16
 * @Version 1.0
 */
public class SearchInRotatedMin {
    //寻找最小值，旋转后的有序数组
    public int findMin(int[] nums) {
        int l=0, r=nums.length-1, mid;
        int min = nums[l];
        while(l<=r){
            mid = (l+r) /2 ;
            min = Math.min(min, nums[mid]);
            //划分递增的左区间或右区间
            if(nums[mid] == nums[l] && nums[mid] == nums[r]){
                l++;
                r--;
            }else if(nums[mid]>=nums[l]){   //左区间递增
                if(nums[l]<nums[r]){
                    r = mid -1;
                }else{
                    l = mid + 1;
                }
            }else{
                if(nums[l]>=nums[r]){
                    r = mid -1;
                }else{
                    l = mid +1;
                }

            }
        }
        return min;
    }

    public static void main(String[] args) {
        int [] nums = {6,2,3,4,5};
        System.out.println(new SearchInRotatedMin().findMin(nums));
    }
}
