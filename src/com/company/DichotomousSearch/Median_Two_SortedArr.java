package com.company.DichotomousSearch;

/**
 * @Author ChanZany
 * @Date 2021/7/3 17:27
 * @Version 1.0
 */
public class Median_Two_SortedArr {
    //归并排序，然后找中位数，复杂度不满足O(log (m+n))
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int count = 0, len1 = nums1.length, len2 = nums2.length;
        int totalLen = len1 + len2;
        int mid1 = 0, mid2 = 0;
        boolean single = true;
        if (totalLen % 2 != 0) mid1 = totalLen / 2;
        else {
            single=false;
            mid1 = (totalLen + 1) / 2;
            mid2 = (totalLen - 1) / 2;
        }
        int[] tmp = new int[totalLen];
        int i = 0, j = 0;
        while (i < len1 && j < len2 && count <= mid1) {
            tmp[count++] = nums1[i] <= nums2[j] ? nums1[i++] : nums2[j++];
        }
        while (i < len1 && count <= totalLen) tmp[count++] = nums1[i++];
        while (j < len2 && count <= totalLen) tmp[count++] = nums2[j++];

        return single?tmp[mid1]:(tmp[mid1]+ tmp[mid2]) / 2.0;
    }

    //由于两个数组都是排序好的，我们在找中位数(k)其实就是在找合并后数组中第k大的元素
    //假设两个数组的长度都大于k/2, 每次去比较两个数组中第k/2个数，如果nums1[k/2]<nums2[k/2]，则可以排除nums[0:k/2]的元素
    //这样，搜索的返回也是每次减少一半，最终可以找到中位数
    //--当某个数组的长度不足k/2时，直接让它停留在数组尾部就可以了
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int left = (len1 + len2 + 1) / 2;
        int right = (len1 + len2 + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k
        return (getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, left)
                + getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, right)) * 0.5;
    }
    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2+k-1];
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1,k/2) - 1;
        int j = start2 + Math.min(len2,k/2) - 1;

        if (nums1[i] > nums2[j])
            return getKth(nums1,start1,end1,nums2,j+1,end2,k-(j-start2+1));
        else
            return getKth(nums1,i+1,end1,nums2,start2,end2,k-(i-start1+1));
    }

    public static void main(String[] args) {
        int [] nums1 = {1,3,5,8};
        int [] nums2 = {2,4};
        System.out.println(new Median_Two_SortedArr().findMedianSortedArrays(nums1, nums2));
    }
}
