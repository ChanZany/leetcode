package com.company.DualPointer;

/**
 * @Author ChanZany
 * @Date 2021/7/2 19:15
 * @Version 1.0
 */
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int place = m-- + n-- -1;
        while(m >= 0 && n >= 0){
            nums1[place--] = nums1[m]>nums2[n]? nums1[m--] : nums2[n--];
        }
        /**
         如果nums1的数字已经复制完，不要忘记把 nums2 的数字继续复制；
         如果 nums2 的数字已经复制完，剩余nums1 的数字不需要改变，因为它们已经被排好序
         */
        while( n >= 0 ){
            nums1[place--] = nums2[n--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0};
        int[] nums2 = {1};
        new Merge().merge(nums1,0, nums2, 1);
    }
}
