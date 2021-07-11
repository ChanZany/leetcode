package com.company.DualPointer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ChanZany
 * @Date 2021/7/3 11:00
 * @Version 1.0
 */
public class LongestWorldInDictionaryThroughDeleting {
    //排序+双指针
    //先按照字典元素长度排序，优先考虑最长的字符串，对其进行字母匹配
    //字母匹配直接用双指针即可
    public String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort((a, b) -> a.length() == b.length() ? a.compareTo(b) : b.length() - a.length());

        for (String str : dictionary)
            if (isContains(str,s)) return str;

        return "";
    }

    private boolean isContains(String str, String container) {
        int j = 0;
        for(int i=0; i<container.length()&&j<str.length(); i++){
            if (str.charAt(j) == container.charAt(i)) j++;
        }
        return j == str.length();
    }

    public static void main(String[] args) {
        ArrayList<String> dic = new ArrayList<>();
        dic.add("ale");
        dic.add("apple");
        dic.add("monkey");

        System.out.println(new LongestWorldInDictionaryThroughDeleting().findLongestWord("abpcplea", dic));
    }
}
