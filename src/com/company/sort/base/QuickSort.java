package com.company.sort.base;

import java.util.Arrays;

/**
 * @Author ChanZany
 * @Date 2021/7/3 19:55
 * @Version 1.0
 */
public class QuickSort {
    public void quickSort(int[] nums, int l, int r){
        if (l > r) return;
        int i = l, j = r;
        int pivot = nums[l];
        while(i<j){
            while(i<j && nums[j]>=pivot) j--;
            while(i<j && nums[i]<=pivot) i++;
            if(i<j) swap(nums, i, j);
        }
        swap(nums, i, l);  //确认了一个pivot=nums[i]=nums[j],该pivot的位置是固定的，说明其是数组中第i/j大的数
        quickSort(nums,l,i-1);
        quickSort(nums,i+1,r);
    }
    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    public static void main(String[] args) {
        int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        new QuickSort().quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

}
