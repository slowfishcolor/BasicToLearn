package com.sfc.algorithms.dynaicprogramming;

/**
 * 这是一个经典的LIS(即最长上升子序列)问题，请设计一个尽量优的解法求出序列的
 * 最长上升子序列的长度。给定一个序列A及它的长度n(长度小于等于500)，请返回LIS的长度。
 测试样例：
 [1,4,2,5,3],5
 返回：3
 * Created by Prophet on 2017/2/16.
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubsequence().getLIS(new int[]{1,4,2,5,3}, 5));
    }
    /**
     * dp[i] : arr[0 - i] 之间的LIS长度
     * @param A
     * @param n
     * @return
     */
    public int getLIS(int[] A, int n) {
        // write code here
        if (A == null || A.length == 0) return 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            // dp[i] 之前中大于A[i]的dp[j]值
            int max = dp[0];
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j] && max <= dp[j]) {
                    max = dp[j];
                    flag = true;
                }
            }
            if (flag) dp[i] = max + 1;
            else dp[i] = max;
        }
        // 找出dp中最大值
        int top = 0;
        for (int i: dp) {
            if (i > top) top = i;
        }
        return top;
    }

}
