package com.sfc.algorithms.dynaicprogramming;

/**
 * 给定数组penny，penny中所有数值为正数且不重复。
 * 每个值代表一种面值的货币，每种面值的货币可以使用任意张。
 * 再给定一个整数aim代表要找的钱数，求换钱有多少种方法。
 * Created by Prophet on 2017/2/16.
 */
public class Exchange {
    public static void main(String[] args) {
        System.out.println(new Exchange().countWays2(new int[]{1, 2, 4}, 3, 3));
    }
    /*****************************************************************/
    /**
     * 暴力搜索
     * @param penny
     * @param n
     * @param aim
     * @return
     */
    public int countWays(int[] penny, int n, int aim) {
        // write code here
        if (penny == null || penny.length == 0 || aim < 0) {
            return 0;
        }
        return countRest(penny, n, aim, 0);
    }

    /**
     * penny从前往后，用i个penny[index]与index之后的有多少种换钱方法
     * 从penny的index之后，有多少种换钱方法。
     *
     * @param penny
     * @param n
     * @param aim
     * @param index
     * @return
     */
    private int countRest(int[] penny, int n, int aim, int index) {
        int result = 0;
        if (index == n) {
            if (aim == 0) result = 1;
            else result = 0;
        } else {
            for (int i = 0; penny[index] * i <= aim; i++) {
                result += countRest(penny, n, aim - penny[index] * i, index + 1);
            }
        }
        return result;
    }
    /*****************************************************************/
    /**
     * 记忆搜索
     * @param penny
     * @param n
     * @param aim
     * @return
     */
    public int countWays1(int[] penny, int n, int aim) {
        // write code here
        if (penny == null || penny.length == 0 || aim < 0) {
            return 0;
        }
        int[][] map = new int[n + 1][ aim + 1];
        return countRest1(penny, n, aim, 0, map);
    }
    private int countRest1(int[] penny, int n, int aim ,int index, int[][] map) {
        int result = 0;
        if (index == n) {
            result = aim == 0 ? 1 : 0;
        } else {
            int mapValue = 0;
            for (int i = 0; penny[index] * i <= aim; i++) {
                mapValue = map[index + 1][aim - penny[index] * i];
                if (mapValue != 0) {
                    result += mapValue == -1 ? 0 : mapValue;
                } else {
                    result += countRest1(penny, n, aim - penny[index] * i, index + 1, map);
                }
            }
        }
        map[index][aim] = result == 0 ? -1 : result;
        return result;
    }
    /*****************************************************************/
    /**
     * 动态规划
     * @param penny
     * @param n
     * @param aim
     * @return
     */
    public int countWays2(int[] penny, int n, int aim) {
        int[] dp = new int[aim + 1];
        // 填充第一行
        for (int j = 0; j <= aim; j++) {
            if (j % penny[0] == 0) dp[j] = 1;
        }
        // 依次填充 1 —— n 行
        for(int i = 1; i < n; i++) {
            for (int j = 1; j <= aim ; j++) {
                if(j >= penny[i])
                    dp[j] = dp[j] + dp[j -penny[i]];
            }
        }
        return dp[aim];
    }

}







