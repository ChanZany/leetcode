package com.company.sort;

import java.util.*;

/**
 * @Author ChanZany
 * @Date 2021/7/4 16:10
 * @Version 1.0
 */
public class TopKFreqElem {
    //考虑出现频率->桶排序
    public int[] topKFrequent(int[] nums, int k) {
        //用Map记录每个数出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        int maxCnt = 0;
        for (int num : nums) {
            int freq = map.getOrDefault(num, 0) + 1;
            map.put(num, freq);
            maxCnt = Math.max(maxCnt, freq);
        }
        //桶排序
        //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
        List<Integer>[] bucket = new List [maxCnt+1];
        for (int idx : map.keySet()) {
            int i_freq = map.get(idx);
            if (bucket[i_freq] == null){
                bucket[i_freq] = new ArrayList<>();
            }
            bucket[i_freq].add(idx);
        }
        //倒序遍历数组获取前k个高频元素
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = bucket.length-1; i >= 0 && res.size()<k; i--) {
            if (bucket[i]==null)continue;
            res.addAll(bucket[i]);
        }

        return contract(res);
    }

    private int[] contract(List<Integer> list){
        int [] res = new int[list.size()];
        int i=0;
        for (Integer item : list) {
            res[i++] = item;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 2};
        System.out.println(Arrays.toString(new TopKFreqElem().topKFrequent(a, 2)));
    }
}
