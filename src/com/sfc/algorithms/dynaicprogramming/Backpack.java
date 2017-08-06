package com.sfc.algorithms.dynaicprogramming;

/**
 * 一个背包有一定的承重cap，有N件物品，每件都有自己的价值，记录在数组v中，
 * 也都有自己的重量，记录在数组w中，每件物品只能选择要装入背包还是不装入背包，
 * 要求在不超过背包承重的前提下，选出物品的总价值最大。给定物品的重量w价值v及物品数n和
 * 承重cap。请返回最大总价值。
 * Created by Prophet on 2017/2/16.
 */
public class Backpack {
    public static void main(String[] args) {
        System.out.println(new Backpack().maxValue(new int[]{1,2,3}, new int[]{1,2,3},3,6));
        System.out.println(new Backpack().maxValueWithPick(new int[]{1,2,3}, new int[]{1,2,3}, new int[3],3,6));
    }
    public int maxValue(int[] w, int[] v, int n, int cap) {
        // write code here
        // dp[x][y] 前 x 件物品，重量不超过y时的最大价值
        // 第x件物品时的情况dp[x][y]：1. 选第x件物品，条件为前x-1件物品的重量<=y-w[x]
        // 价值为dp[x-1][y-w[x]] + v[x]
        // 2. 不选第x件物品时， dp[x][y] = dp [x-1][y]
        int[][] dp = new int[n + 1][cap + 1];
        for (int x = 1; x < n + 1; x++) {
            for (int y = 1; y < cap + 1; y++) {
                int a = dp[x-1][y];
                int b = 0;
                // dp[][] 下标为 0 - n，w 下标为 0 - n-1,
                if (y - w[x-1] >= 0) b = dp[x-1][y-w[x-1]] + v[x-1];
                dp[x][y] = Math.max(a, b);
            }
        }
        return dp[n][cap];
    }

    public int maxValue2(int[] w, int[] v, int n, int cap) {
        // dp[x][y]表示物品数量为x,重量不超过y时背包中的总价值
        //两种情况：1.将x物品不加入到背包中，那么前x-1件物品的总重量不应该超过y。dp[x][y] = dp[x-1][y]
        //2.将x物品加入到背包中，那么前x-1前物品的总重量不应该超过y-w(x),因此dp[x][y] = dp[x-1][y-w(x)]+v(x);
        int[] dp = new int[cap+1];

        for(int i=0;i<n;i++){//控制物品的数量
            for(int j=cap;j>=w[i];j--){//空背包中不能超重, 倒着来可以保证 cap
                dp[j] = dp[j]>=dp[j-w[i]]+v[i]?dp[j]:dp[j-w[i]]+v[i];//选取j加入书包与j不加入书包的较大值
            }
        }

        return dp[cap];//返回数组的最后一位即是最大总价值

    }

    /**
     * result[]最大值的时候，选择的情况
     * @param w
     * @param v
     * @param result
     * @param n
     * @param cap
     * @return
     */
    public int maxValueWithPick(int[] w, int[] v, int[] result, int n, int cap) {
        // write code here
        // dp[x][y] 前 x 件物品，重量不超过y时的最大价值
        // 第x件物品时的情况dp[x][y]：1. 选第x件物品，条件为前x-1件物品的重量<=y-w[x]
        // 价值为dp[x-1][y-w[x]] + v[x]
        // 2. 不选第x件物品时， dp[x][y] = dp [x-1][y]
        int[][] dp = new int[n + 1][cap + 1];
        for (int x = 1; x < n + 1; x++) {
            for (int y = 1; y < cap + 1; y++) {
                int a = dp[x-1][y];
                int b = 0;
                // dp[][] 下标为 0 - n，w 下标为 0 - n-1,
                if (y - w[x-1] >= 0) b = dp[x-1][y-w[x-1]] + v[x-1];
                dp[x][y] = Math.max(a, b);
            }
        }

        // 从最后一个元素倒着往回找
        int j = cap;
        for (int i = n; i > 0 ; i--) {
            if (dp[i][j] > dp[i-1][j]) {
                result[i-1] = 1;
                j = j - w[i-1];
            }
            else {
                result[i-1] = 0;
            }
        }


        return dp[n][cap];
    }
}
