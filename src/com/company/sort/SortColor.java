package com.company.sort;

import java.util.Arrays;

/**
 * @Author ChanZany
 * @Date 2021/7/4 22:00
 * @Version 1.0
 */
public class SortColor {

    //注意是原地排序，所以不能采用桶排序/归并的方法，只能通过元素交换的方式完成该问题
    //考虑到快速排序每次迭代都会确认一个pivot，pivot左边的值全小于自己，右边的全大于等于自己
    //这样可以划分出两组数据，假设pivot是1，在经过一次迭代后，其左边的元素全为0，其右边的元素为1,2
    //然后考虑对右边的数据进行分组，设置pivot是2，即可完成
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1;
        int pivot_idx = quickPartiton(nums, l, r, 1);
        quickPartiton(nums, pivot_idx, r, 2);
    }

    private int quickPartiton(int[] a, int l, int r, int pivot_value) {

        while (l < r) {
            while (l < r && a[r] >= pivot_value) r--;
            while (l < r && a[l] < pivot_value) l++;
            if (l < r) swap(a, l, r);
        }
        return l;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int [] nums = {1};
        new SortColor().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

}
