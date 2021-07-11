package com.company.SearchAlgorithm.BT;

/**
 * @Author ChanZany
 * @Date 2021/7/5 14:22
 * @Version 1.0
https://leetcode-cn.com/problems/word-search/solution/shen-du-you-xian-sou-suo-yu-hui-su-xiang-jie-by-ja/
https://leetcode-cn.com/problems/word-search/solution/zai-er-wei-ping-mian-shang-shi-yong-hui-su-fa-pyth/
 */
public class WordSearch {
    private static int[] direction = {-1, 0, 1, 0, -1};
    private boolean find = false;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board.length > 0 ? board[0].length : 0;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0))
                    backtrack_err(i, j, board, word, visited, 0);
            }
        }
        return find;
    }


    private void backtrack_err(int i, int j, char[][] board, String word, boolean[][] visited, int pos) {
        if (pos == word.length() - 1) {
            find = true;
            return;
        }
        visited[i][j] = true;
        int x, y;
        for (int k = 0; k < 4; k++) {
            x = i + direction[k];
            y = j + direction[k + 1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length
                    && !visited[x][y] && board[x][y] == word.charAt(pos + 1)) {
                backtrack_err(x, y, board, word, visited, pos + 1);
            }
        }
        visited[i][j] = false;
    }

    private void backtrack(int i, int j, char[][] board, String word, boolean[][] visited, int pos) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        if (visited[i][j] || find || board[i][j] != word.charAt(pos)) return;
        if (pos == word.length() - 1) {
            find = true;
            return;
        }
        visited[i][j] = true;
        backtrack(i + 1, j, board, word, visited, pos + 1);
        backtrack(i - 1, j, board, word, visited, pos + 1);
        backtrack(i, j + 1, board, word, visited, pos + 1);
        backtrack(i, j - 1, board, word, visited, pos + 1);
        visited[i][j] = false;
    }


    public static void main(String[] args) {
        WordSearch Main = new WordSearch();
        char[][] board = new char[1][];
        board[0] = new char[]{'a'};
        System.out.println(Main.exist(board, "b"));
    }
}
