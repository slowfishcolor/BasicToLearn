package com.sfc.algorithms.dynaicprogramming;

/**
 * 有一个矩阵map，它每个格子有一个权值。从左上角的格子开始每次只能向右或者向下走，
 * 最后到达右下角的位置，路径上所有的数字累加起来就是路径和，
 * 返回所有的路径中最小的路径和。给定一个矩阵map及它的行数n和列数m，
 * 请返回最小路径和。保证行列数均小于等于100.
 * 测试样例：[[1,2,3],[1,1,1]],2,3返回：4
 * Created by Prophet on 2017/2/16.
 */
public class MinimumPath {
    public static void main(String[] args) {
        int[][] map = new int[][]{{1,2,3},{1,1,1}};
        System.out.println(new MinimumPath().getMin1(map, 2, 3));
    }
    /**
     * 递归求解
     * @param map
     * @param n
     * @param m
     * @return
     */
    public int getMin(int[][] map, int n, int m) {
        // write code here
        int[][] dp = new int[n][m];
        // 填充dp第一行和第一列
        dp[0][0] = map[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = map[i][0] + dp[i-1][0];
        }
        for (int i = 1; i < m; i++) {
            dp[0][i] = map[0][i] + dp[0][i - 1];
        }
        return getMin(map, n, m, dp, n-1,m-1);
    }
    private int getMin(int[][] map, int n, int m, int[][] dp, int i, int j) {
        if (i == 0 || j == 0)
            return dp[i][j] + map[i][j];
        if (dp[i-1][j] < dp[i][j-1]) {
            dp[i][j] = map[i][j] + dp[i - 1][j];
            i--;
            return getMin(map, n, m, dp, i,j);
        }
        else {
            dp[i][j] = map[i][j] + dp[i][j - 1];
            j--;
            return getMin(map, n, m, dp, i,j);
        }
    }

    /**
     * 动态规划
     * @param map
     * @param n
     * @param m
     * @return
     */
    public int getMin1(int[][] map, int n, int m) {
        // write code here
        int[][] dp = new int[n][m];
        // 填充dp第一行和第一列
        dp[0][0] = map[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = map[i][0] + dp[i-1][0];
        }
        for (int i = 1; i < m; i++) {
            dp[0][i] = map[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (dp[i-1][j] < dp[i][j-1]) {
                    dp[i][j] = map[i][j] + dp[i - 1][j];
                } else {
                    dp[i][j] = map[i][j] + dp[i][j - 1];
                }

            }
        }
        return dp[n - 1][m - 1];
    }
}
