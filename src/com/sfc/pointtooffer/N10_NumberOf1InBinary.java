package com.sfc.pointtooffer;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 *  把一个整数减去 1，再和原整数做与运算，会把最右边一个 1 变成 0，
 *  那么一个整数的二进制表示中有多少个 1，就可以进行多少次这样的操作。
 *
 * Created by Prophet on 2017/9/17.
 */
public class N10_NumberOf1InBinary {

    public static void main(String[] args) {
        int a = 0xfffffffe;
        System.out.println(Integer.toHexString(a));
        System.out.println(Integer.toBinaryString(a));
        long b = 0xffffffffffffffffL;
        System.out.println(a >>> 1);
        System.out.println(a >> 1);
        System.out.println(0x7fffffff);
        System.out.println(0x80000000);
        System.out.println(0xffffffff);

    }

    public int NumberOf1(int n) {
        int count = 0;

        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }

        return count;
    }
}
