package com.sfc.pointtooffer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * Created by Prophet on 2017/9/17.
 */
public class N09_1_JumpFloor {
    public int JumpFloor(int target) {
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
