package com.company.sort.base;

import java.util.Arrays;

/**
 * @Author ChanZany
 * @Date 2021/7/4 14:26
 * @Version 1.0
 */
public class ShellSort {

    public void shellSort(int[] a) {
        //1.根据数组a的长度，确定增长量h的初始值, 依据h对数据进行分组
        int h = 1;
        while (h < a.length / 2) h = 2 * h + 1;
        while (h >= 1) {
            //2.对每个组进行插入排序
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (a[j] < a[j - h]) swap(a, j, j - h);
                    else break;
                }
            }
            //3.减少h的值直到1，重复第二步的操作
            h = h / 2;
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        new ShellSort().shellSort(a);
        System.out.println(Arrays.toString(a));
    }
}
