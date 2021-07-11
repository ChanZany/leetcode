package com.company.DichotomousSearch;

/**
 * @Author ChanZany
 * @Date 2021/7/3 11:28
 * @Version 1.0
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去
 */
public class Sqrt {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int l = 1, r = x, mid, sqrt;
        while (l <= r) {
            mid = (l + r) / 2;
            sqrt = x / mid;
            if (sqrt == mid) return mid;
            else if (sqrt > mid) l = mid + 1;   //说明mid小了
            else r = mid - 1;
        }
        return r;                               //向下取整
    }

    public static void main(String[] args) {
        System.out.println(new Sqrt().mySqrt(6));
    }

}
