package com.sfc.pointtooffer;

/**
 * 给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent。
 * 求 base 的 exponent 次方。
 * <p>
 * 可以考虑对指数折半，这样只需要计算一半的值，若指数是奇数，则 -1 再折半，否则直接折半。
 * <p>
 * Created by Prophet on 2017/9/17.
 */
public class N11_Power {

    public static void main(String[] args) {
        System.out.println(Power(2, 3));
        System.out.println(Power(2, -3));
        System.out.println(powerSlow(2, 3));
        synchronized (N11_Power.class) {


            long startTime = System.currentTimeMillis();
            for (int j = 0; j < 100000; j++) {
                for (int i = 0; i < 100; i++) {
                    Power(1.5, i);
                }
            }
            System.out.println(System.currentTimeMillis() - startTime);

            startTime = System.currentTimeMillis();
            for (int j = 0; j < 100000; j++) {
                for (int i = 0; i < 100; i++) {
                    powerSlow(1.5, i);
                }
            }
            System.out.println(System.currentTimeMillis() - startTime);
        }


    }

    public static double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        boolean negative = false;
        if (exponent < 0) {
            exponent = -exponent;
            negative = true;
        }

        // 除以 2
        int exponent_1 = exponent >> 1;
        double temp = Power(base, exponent_1);
        temp *= temp;
        // 奇数
        if ((exponent & 0x01) != 0) {
            temp *= base;
        }

        if (negative) {
            temp = 1 / temp;
        }

        return temp;

    }

    public static double powerSlow(double base, int exponent) {
        double result = 1.0;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }
}
