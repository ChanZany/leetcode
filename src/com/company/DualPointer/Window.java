package com.company.DualPointer;

/**
 * @Author ChanZany
 * @Date 2021/7/2 19:43
 * @Version 1.0
 */
public class Window {
    public String minWindow2(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        int[] need = new int[128];
        //记录需要的字符的个数
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        //l是当前左边界，r是当前右边界，size记录窗口大小，count是需求的字符个数，start是最小覆盖串开始的index
        int l = 0, r = 0, size = Integer.MAX_VALUE, count = t.length(), start = 0;
        //遍历所有字符
        while (r < s.length()) {
            char c = s.charAt(r);
            if (need[c] > 0) {//需要字符c
                count--;
            }
            need[c]--;//把右边的字符加入窗口
            if (count == 0) {//窗口中已经包含所有字符
                while (l < r && need[s.charAt(l)] < 0) {
                    need[s.charAt(l)]++;//释放右边移动出窗口的字符
                    l++;//指针右移
                }
                if (r - l + 1 < size) {//不能右移时候挑战最小窗口大小，更新最小窗口开始的start
                    size = r - l + 1;
                    start = l;//记录下最小值时候的开始位置，最后返回覆盖串时候会用到
                }
                //l向右移动后窗口肯定不能满足了 重新开始循环
                need[s.charAt(l)]++;
                l++;
                count++;
            }
            r++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }

    public String minWindow(String s, String t) {
        int[] appeared = new int[128];
        boolean[] flag = new boolean[128];
        for (int i = 0; i < t.length(); i++) {
            flag[t.charAt(i)] = true;       //记录每个目标值
            ++appeared[t.charAt(i)];        //将目标值出现的次数初始化为1
        }
        // 移动滑动窗口，不断更改统计数据
        int cnt = 0, l = 0, min_l = 0, min_size = s.length() + 1;
        char[] chs = s.toCharArray();
        for (int r = 0; r < s.length(); r++) {
            if (flag[chs[r]]) {             //出现目标值
                if (--appeared[chs[r]] >= 0) {              //将每个出现的目标字符对应值-1,目标字符->0
                    ++cnt;
                }
                // 若目前滑动窗口已包含T中全部字符，
                // 则尝试将l右移，在不影响结果的情况下获得最短子字符串
                while (cnt == t.length()) {
                    if (r - l + 1 < min_size) {
                        min_l = l;
                        min_size = r - l + 1;
                    }
                    if (flag[chs[l]] && ++appeared[chs[l]] > 0) { //右移直到遇到下一个目标字符，cnt--，跳出while
                        --cnt;
                    }
                    ++l;
                }
            }
        }
        return min_size > s.length() ? "" : s.substring(min_l, min_l + min_size);
    }

    public static void main(String[] args) {
        System.out.println(new Window().minWindow("ADOBECODEBANC", "ABC"));
    }
}
