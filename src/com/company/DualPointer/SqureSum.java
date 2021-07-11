package com.company.DualPointer;

/**
 * @Author ChanZany
 * @Date 2021/7/3 9:56
 * @Version 1.0
 */
public class SqureSum {
    public boolean judgeSquareSum(int c) {
        long left = 0;
        long right = (long)Math.sqrt(c);
        while(left <= right){
            long res =  left * left + right * right;
            if (res == c) return true;
            else if (res>c){
                right --;
            }else left++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new SqureSum().judgeSquareSum(1));
    }
}
