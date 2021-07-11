package com.company.sort;

import java.util.*;

/**
 * @Author ChanZany
 * @Date 2021/7/4 19:09
 * @Version 1.0
 */
public class SortCharactersByFreq {
    public String frequencyBySort(String s){
        char[] chs = s.toCharArray();

        //对chs按照频率排序->桶排序
        HashMap<Character, Integer> map = new HashMap<>();
        int maxCnt = 0;
        for(char c: chs){
            int freq = map.getOrDefault(c, 0) + 1;
            map.put(c, freq);
            maxCnt = Math.max(maxCnt, freq);
        }
        List<Character>[] bucket = new List[maxCnt+1];
        for(char c:map.keySet()){
            int freq = map.get(c);
            if (freq ==0) continue;
            if (bucket[freq]==null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(c);
        }
        StringBuilder res = new StringBuilder();
        for (int i=maxCnt;i>0;i--){
            if (bucket[i]==null) continue;
            for (int j = 0; j<bucket[i].size();j++){
                for (int k=0; k<i;k++){
                    res.append(bucket[i].get(j));
                }
            }

        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new SortCharactersByFreq().frequencyBySort("abcaab"));
    }
}
