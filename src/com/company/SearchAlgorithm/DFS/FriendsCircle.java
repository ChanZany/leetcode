package com.company.SearchAlgorithm.DFS;

/**
 * @Author ChanZany
 * @Date 2021/7/5 10:52
 * @Version 1.0
https://leetcode-cn.com/problems/number-of-provinces/solution/python-duo-tu-xiang-jie-bing-cha-ji-by-m-vjdr/
 */
public class FriendsCircle {
    //isConnected[i][j]=1,说明j是i的朋友，然后找j的朋友isConnected[j][k]=1，则i,j,k为一个朋友圈
    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length, cnt=0;
        boolean[] visited = new boolean[m];
        for (int i=0;i<m;i++){
            if (!visited[i]){
                dfs(isConnected,i,visited); //一次dfs会让单个朋友圈所有人都处于visited状态，下一次进行到这个if语句一定是另一个朋友圈的人即visited[i]=false
                cnt++;
            }
        }
        return cnt;
    }

    private void dfs(int[][] isConnected, int i, boolean[] visited) {
        visited[i] = true;
        for (int k=0;k<isConnected.length;k++){
            if (isConnected[i][k]==1 && !visited[k]){
                dfs(isConnected,k,visited);
            }
        }
    }

}
