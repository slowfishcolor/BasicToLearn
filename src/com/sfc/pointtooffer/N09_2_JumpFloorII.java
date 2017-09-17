package com.sfc.pointtooffer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * 通过数学归纳可以证明是 2 ^ n - 1;
 *
 * Created by Prophet on 2017/9/17.
 */
public class N09_2_JumpFloorII {
    public int JumpFloorII(int target) {
        if (target == 1) return 1;
        return 2 << (target - 2);
    }
}
