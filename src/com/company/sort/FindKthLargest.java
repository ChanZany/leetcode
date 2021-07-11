package com.company.sort;

/**
 * @Author ChanZany
 * @Date 2021/7/4 16:08
 * @Version 1.0
 */
public class FindKthLargest {
    //快速排序，找到第k大的pivot时返回即可
    public int findKthLargest(int[] nums, int k) {
        int l=0, r=nums.length-1;
        int target = nums.length - k;
        while(l<r){
            int mid = quickSelect(nums, l, r);
            if(mid == target){
                return nums[mid];
            }
            //二分查找
            if(mid < target){
                l = mid  + 1;
            }else{
                r = mid - 1;
            }
        }
        return nums[l];
    }

    //在区间nums[l:r]中找到一个基准pivot,其左边的元素都小于它，右边的元素都大于它，返回其下标
    private int quickSelect(int[] nums, int l, int r){
        int i = l, j = r;
        int pivot = nums[l];
        while(i<j){
            while(i<j && nums[j]>=pivot) j--;
            while(i<j && nums[i]<=pivot) i++;
            if(i<j) swap(nums, i, j);
        }
        swap(nums, i, l);  //确认了一个pivot=nums[i]=nums[j],该pivot的位置是固定的，说明其是数组中第i/j大的数
        return j;
    }

    private void swap(int[] nums, int i , int j){
        int tmp =  nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
