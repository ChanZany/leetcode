package com.company.DP;

import java.util.Arrays;
import java.util.List;

/**
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * @Author ChanZany
 * @Date 2021/7/9 15:13
 * @Version 1.0
 * 分析：单词就是物品，背包就是s,单词能否组成字符串s，就是问物品能不能把背包装满，而单词可以是一个或多个，所以是多重背包问题
 * 定义：对于字符串s[0:j],dp[j]=true表示可以将之拆分为一个或多个字典中出现的单词
 * 转移：dp[j] |= dp[j-dict[i]]
 * 初始化：dp[0]=true，无意义，为了递推成功
 * 遍历顺序：由于每次判别的是字符子串，最好遍历背包放在外循环，遍历物品放在内循环，减少字符串分割的次数和开销
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {     //外层遍历背包
            for (int j = 0; j <i; j++) { //内层遍历物品
                String word = s.substring(j,i);
                System.out.println(word);
                if (wordDict.contains(word) && dp[j]) dp[i] = true;
                System.out.println(Arrays.toString(dp));
            }

        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreak Main = new WordBreak();
        String s = "leetcode";
        List<String> dict = Arrays.asList("leet", "code");
        Main.wordBreak(s, dict);
    }
}
