package com.company.SearchAlgorithm.DFS;

/**
 * @Author ChanZany
 * @Date 2021/7/5 21:00
 * @Version 1.0
 * <p>https://leetcode-cn.com/problems/surrounded-regions/solution/dfs-bfs-bing-cha-ji-by-powcai/
 * DFS/BFS
 */
public class SurroundedRegions {
    int row, col;
    public void solve(char[][] board) {
        row = board.length;
        col = row>0?board[0].length:0;
        //从边界入侵
        for(int i=0;i<row;i++){
            dfs(board,i,0);     //第一列
            dfs(board,i,col-1); //最后一列
        }
        for(int j=0;j<col;j++){
            dfs(board,0,j);     //第一行
            dfs(board,row-1,j); //最后一行
        }
        //dfs中将边界上的O以及与这些O相连的O都置换为了'-'
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j] =='O') board[i][j] ='X';
                if(board[i][j] =='-') board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board,int x,int y){
        if(x<0 || y<0 || x>=row || y>=col || board[x][y]!='O'){
            return;
        }
        //进来了说明边界上有'O'，borad[x][y]=='O',此时需要找到与之相连的'O'
        //并全部更换为'-'
        board[x][y] = '-';
        dfs(board,x+1,y);
        dfs(board,x-1,y);
        dfs(board,x,y+1);
        dfs(board,x,y-1);
    }
}
