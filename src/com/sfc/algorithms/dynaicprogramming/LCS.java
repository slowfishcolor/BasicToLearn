package com.sfc.algorithms.dynaicprogramming;

/**
 * TODO: http://blog.csdn.net/biangren/article/details/8038605
 * 给定两个字符串A和B，返回两个字符串的最长公共子序列的长度。
 * 例如，A="1A2C3D4B56”，B="B1D23CA45B6A”，”123456"或者"12C4B6"都是最长公共子序列。
 * 给定两个字符串A和B，同时给定两个串的长度n和m，请返回最长公共子序列的长度。
 * 保证两串长度均小于等于300。
 测试样例：
 "1A2C3D4B56",10,"B1D23CA45B6A",12
 返回：6
 * Created by Prophet on 2017/2/16.
 */
public class LCS {
    public static void main(String[] args) {
        String A="1A2C3D4B56";
        String B="B1D23CA45B6A";
//        String A = "ABC";
//        String B = "AB";
        System.out.println(new LCS().findLCS(A,A.length(),B, B.length()));
    }
    /**
     * dp[i][j] str1[0-i] 与 str2[0-j] 的最长公共子序列
     * @param A
     * @param n
     * @param B
     * @param m
     * @return
     */
    public int findLCS(String A, int n, String B, int m) {
        // write code here
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int[][] dp = new int[n][m];
        // 填充第一列
        // 找到第一个AB相等的index
        int index = n;
        for(int i = 0; i < n; i++) {
            if (a[i] == b[0]) {
                index = i;
                break;
            }
        }
        // 填充
        for (int i = 0; i < index; i++) {
            dp[i][0] = 0;
        }
        for (int i = index; i < n; i++) {
            dp[i][0] = 1;
        }

        // 填充第一行
        // 找到第一个AB相等的index
        index = m;
        for (int i = 0; i < m; i++) {
            if (b[i] == a[0]) {
                index = i;
                break;
            }
        }
        for (int i = 0; i < index; i++) {
            dp[0][i] = 0;
        }
        for (int i = index; i < m; i++) {
            dp[0][i] = 1;
        }

        // 逐行填充d[i][j]
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int p = dp[i -1][j];
                int q = dp[i][j-1];
                int r = 0;
                if (a[i] == b[j]) r = dp[i-1][j-1] + 1;
                dp[i][j] = findMax3(p,q,r);
            }
        }

        return dp[n-1][m-1];
    }

    private int findMax3(int a, int b, int c) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        return max;
    }
}












