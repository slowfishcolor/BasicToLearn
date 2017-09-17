package com.sfc.pointtooffer;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * 仍是斐波那契数列
 *
 * Created by Prophet on 2017/9/17.
 */
public class N09_3_RectCover {
    public int RectCover(int target) {
        if (target < 1) return 0;
        if (target == 1 || target == 2) return target;
        int f1 = 1;
        int f2 = 2;
        for (int i = 3; i <= target; i++) {
            int t = f2;
            f2 = f1 + f2;
            f1 = t;
        }
        return f2;
    }
}
