package com.company.DualPointer;

/**
 * @Author ChanZany
 * @Date 2021/7/3 10:09
 * @Version 1.0
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * [abac] -> left=a,right=c.不等，
 * 删除a(cnt++)-> [baca],left++ (递归)
 * or
 * 删除c(cnt++)-> [aba],right-- (递归)
 * left=a,right=a.相等 -> left++ , right--
 */
public class ValidPalindrome {
    //双指针+贪心
    public boolean validPalindrome(String s) {
        for (int l = 0, r = s.length() - 1; l < r; l++, r--) {
            if (s.charAt(l) != s.charAt(r))     //最多删除一个字符，所以只用进行一次判断
                return validPalindrome(s, l + 1, r) || validPalindrome(s, l, r - 1);
        }
        return true;
    }

    public boolean validPalindrome(String s, int l, int r) {
        while (l<r){
            if (s.charAt(l++)!=s.charAt(r--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
}
