package com.sfc.pointtooffer;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数 n，请你输出斐波那契数列的第n项。
 *
 * Created by Prophet on 2017/9/17.
 */
public class N09_Fibonacci {
    public int fibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public int fibonacci_i(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        int f1 = 1;
        int f2 = 1;
        int fn = 1;
        for (int i = 2; i < n; i++) {
            fn = f1 + f2;
            f1 = f2;
            f2 = fn;
        }
        return fn;
    }
}
