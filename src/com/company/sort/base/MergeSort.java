package com.company.sort.base;

import java.util.Arrays;

/**
 * @Author ChanZany
 * @Date 2021/7/4 12:32
 * @Version 1.0
 */
public class MergeSort {

    int[] assist = null;

    //先分--后合
    public void mergeSort(int[] a) {
        assist = new int[a.length];
        mergeSort(a, 0, a.length - 1);
    }

    private void mergeSort(int[] a, int l, int r) {
        //递归出口
        if (l >= r) return;
        //二分数据
        int mid = l + (r - l) / 2;
        //分别对每一组数据进行排序
        mergeSort(a, l, mid);
        mergeSort(a, mid + 1, r);
        //将两个组中的数据进行归并
        merge(a, l, mid, r);
    }

    /*将数组a[l:mid]和a[mid+1:r]的数据进行归并*/
    private void merge(int[] a, int l, int mid, int r) {
        //定义三个指针
        int i = l, p1 = l, p2 = mid + 1;
        //遍历，移动指针p1,p2,比较对应索引处的值，每次将小的哪个放入辅助数组的对应索引
        while (p1 <= mid && p2 <= r) {
            assist[i++] = a[p1] < a[p2] ? a[p1++] : a[p2++];
        }
        //如果p1的指针没有走完，那么顺序移动p1指针，把对应元素放入辅助数组的对应索引处
        while (p1 <= mid) assist[i++] = a[p1++];
        while (p2 < r) assist[i++] = a[p2++];
        //把辅助数组中的元素拷贝到原数组中
        for (int k = l; k <= r; k++)
            a[k] = assist[k];
    }

    public static void main(String[] args) {
        int[] a = {6, 5, 4, 3, 2, 1};
        new MergeSort().mergeSort(a);
        System.out.println(Arrays.toString(a));
    }


}
