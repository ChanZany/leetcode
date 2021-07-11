package com.company.SearchAlgorithm.BFS;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * @Author ChanZany
 * @Date 2021/7/5 19:07
 * @Version 1.0

https://leetcode-cn.com/problems/word-ladder-ii/solution/yan-du-you-xian-bian-li-shuang-xiang-yan-du-you--2/
 */
public class WordLadder {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);         //用于快速判断扩展出的单词是否在wordList里
        if (!dict.contains(endWord)) return res;            //特殊用例检查

        dict.remove(beginWord);                             //从beginWord开始扩展，所以dict里一定不能有beginWord

        //1. BFS遍历构建图
        Map<String,Integer> steps = new HashMap<>();        //为避免记录不需要的边，需要知道扩展出的单词是否是同层的
        steps.put(beginWord,0);

        Map<String,Set<String>> from = new HashMap<>();     //key-toWord, value-fromWords
        boolean found = bfs(beginWord,endWord,dict,steps,from);

        //2. DFS遍历所有解，从endWord恢复到beginWord,每次尝试操作 path 列表的头部
        if (found){
            Deque<String> path = new ArrayDeque<>();
            path.add(endWord);
            dfs(from,path,beginWord,endWord,res);
        }
        return res;
    }

    private void dfs(Map<String, Set<String>> from, Deque<String> path, String beginWord, String cur, List<List<String>> res) {
        if (cur.equals(beginWord)){
            res.add(new ArrayList<>(path));
            return;
        }
        for (String precursor: from.get(cur)){
            path.addFirst(precursor);
            dfs(from,path,beginWord,precursor,res);
            path.removeFirst();
        }
    }

    private boolean bfs(String beginWord, String endWord, Set<String> dict, Map<String, Integer> steps, Map<String, Set<String>> from) {
        int wordLen = beginWord.length();
        int step = 0;
        boolean found = false;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()){
            step++;
            int size = queue.size();
            for(int i=0;i<size;i++){
                String curWord = queue.poll();
                char[] chs = curWord.toCharArray();
                //扩展
                for (int j = 0; j < wordLen; j++) {
                    char origin = chs[j];
                    // 将每一位替换成 26 个小写英文字母
                    for (char c ='a'; c<='z';c++){
                        chs[j] = c;
                        String nextWord = String.valueOf(chs);
                        // 注意：这几行代码的逻辑先后顺序
                        // dict 和 steps 承担了已经访问的功能
                        // 多个fromWord到nextWord时，需要判断这些fromWord是否为同层
                        if (steps.containsKey(nextWord) && steps.get(nextWord) == step){
                            from.get(nextWord).add(curWord);
                        }
                        if (!dict.contains(nextWord)) continue;
                        dict.remove(nextWord);

                        queue.offer(nextWord);
                        // 维护 from、steps、found 的定义
                        from.putIfAbsent(nextWord, new HashSet<>());
                        from.get(nextWord).add(curWord);
                        steps.put(nextWord,step);
                        // 注意：由于有多条路径到达 endWord 找到以后不能立即退出，只需要设置 found = true 即可
                        if (nextWord.equals(endWord)) found=true;
                    }
                    //回溯
                    chs[j] = origin;
                }
            }
            if (found) break;
        }
        return found;
    }

    public static void main(String[] args) {
        WordLadder Main = new WordLadder();
        List<List<String>> ladders = Main.findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        for (List<String> ladder : ladders) {
            ladder.forEach(s-> System.out.print(s+"\t"));
            System.out.println();
        }
    }

}
