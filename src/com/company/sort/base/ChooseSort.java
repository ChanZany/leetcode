package com.company.sort.base;

import java.util.Arrays;

/**
 * @Author ChanZany
 * @Date 2021/7/4 14:11
 * @Version 1.0
 */
public class ChooseSort {
    //在每一次遍历开始，都假定第一个索引处的元素是最小值，和其他索引处的值依次进行比较，更新最小值所在索引
    //在每一次遍历结束时，交换第一个索引处和最小值所在的索引处的值
    //每次遍历可以确定一个数组左侧的元素
    //冒泡排序每次确定一个大端值，选择排序每次确定一个小端值
    public void chooseSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < a.length; j++) {
                minIdx = a[j] < a[minIdx] ? j : minIdx;
            }
            swap(a, i, minIdx);
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        new ChooseSort().chooseSort(a);
        System.out.println(Arrays.toString(a));
    }
}
