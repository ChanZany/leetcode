package com.company.SearchAlgorithm.BT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author ChanZany
 * @Date 2021/7/5 16:00
 * @Version 1.0
 * https://leetcode-cn.com/problems/n-queens/solution/dai-ma-sui-xiang-lu-51-n-queenshui-su-fa-2k32/
 */
public class SolveNQueens {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        backtrack(n, 0, chessboard);
        return res;
    }

    private void backtrack(int n, int row, char[][] chessboard) {
        if (row == n) {
            res.add(Array2List(chessboard));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n, chessboard)) {
                chessboard[row][col] = 'Q';
                backtrack(n, row + 1, chessboard);
                chessboard[row][col] = '.';
            }
        }
    }

    private List<String> Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();
        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    private boolean isValid(int row, int col, int n, char[][] chessboard) {
        //每一层递归，只会选for循环（也就是同一行）里的一个元素，所以不用检查行了
        //检查列
        for (int i = 0; i < n; i++) {
            if (chessboard[i][col] == 'Q') return false;
        }

        //检查正对角线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') return false;
        }
        //检查反对角线
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q') return false;
        }

        return true;
    }
}
