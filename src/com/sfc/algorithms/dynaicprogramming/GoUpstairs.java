package com.sfc.algorithms.dynaicprogramming;

/**
 * 有n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法。
 * 为了防止溢出，请将结果Mod 1000000007
 * 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
 * Created by Prophet on 2017/2/16.
 */
public class GoUpstairs {
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        System.out.println(new GoUpstairs().countWays1(40));
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }
    /**
     * 递归暴力搜索
     *
     * @param n
     * @return
     */
    public int countWays(int n) {
        // write code here
        if (n < 1) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        return countWays(n - 1) + countWays(n - 2);
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public int countWays1(int n) {
        if (n < 1) return 0;
        if (n == 1 || n == 2) return n;
        int f1 = 1;
        int f2 = 2;
        for (int i = 3; i <= n; i++) {
            int t = f2;
            f2 = f1 + f2;
            f1 = t;
        }
        return f2;
    }


}
