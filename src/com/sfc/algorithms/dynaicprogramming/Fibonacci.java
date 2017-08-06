package com.sfc.algorithms.dynaicprogramming;

/**
 * 给定整数A，返回Fibonacci数列的第N项
 * Created by Prophet on 2017/2/16.
 */
public class Fibonacci {
    public static int rFib(int n) {
        if (n < 1) return 0;
        if (n < 2) return 1;
        return rFib(n-1) + rFib(n-2);
    }

    public static int nFib(int n) {
        if (n < 1) return 0;
        if (n < 2) return 1;
        int pre = 1;
        int next = 1;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = next;
            next = pre + next;
            pre = temp;
        }
        return next;
    }



    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
//        int result = rFib(40);
        int result = nFib(40);
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - begin));
    }
}
