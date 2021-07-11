package com.company.sort.base;

import java.util.Arrays;

/**
 * @Author ChanZany
 * @Date 2021/7/4 14:18
 * @Version 1.0
 */
public class BubbleSort {
    public void bubbleSort(int[] a) {
        for (int i = a.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j]>a[j+1]) swap(a,j,j+1);
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
        new BubbleSort().bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }
}
