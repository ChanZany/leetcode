package com.company.sort.base;

import java.util.Arrays;

/**
 * @Author ChanZany
 * @Date 2021/7/4 13:49
 * @Version 1.0
 */
public class InsertSort {
    //插入排序--扑克牌
    //找到未排序部分的第一个元素，向已经排序的部分进行插入
    //倒序遍历已经排序的元素，依次和待插入元素进行比较，直到找到一个元素小于等于待插入元素，那么就把待插入元素放入这个位置，其他的元素往后移一位
    public void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            //倒序遍历已排序的元素，插入当前元素
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) swap(a, j, j - 1);
                else break;
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


    public static void main(String[] args) {
        int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        new InsertSort().insertSort(a);
        System.out.println(Arrays.toString(a));
    }
}
