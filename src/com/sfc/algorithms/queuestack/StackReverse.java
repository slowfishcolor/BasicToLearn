package com.sfc.algorithms.queuestack;

import java.util.Stack;

/**
 * 实现一个栈的逆序，但是只能用递归函数和这个栈本身的pop操作来实现，
 * 而不能自己申请另外的数据结构。给定一个整数数组A即为给定的栈，
 * 同时给定它的大小n，请返回逆序后的栈。
 测试样例：
 [4,3,2,1],4
 返回：[1,2,3,4]
 * Created by Prophet on 2017/2/17.
 */
public class StackReverse {
    public int[] reverseStack(int[] A, int n) {
        // write code here
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(A[i]);
        }
        reverse(stack);
        for (int i = n - 1; i >=0; i--) {
            A[i] = stack.pop();
        }
        return A;
    }


    /**
     * 把栈中元素逆序
     * @param stack
     */
    private void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        int i = get(stack);
        reverse(stack);
        stack.push(i);
    }

    /**
     * 移除栈顶元素并返回
     * @param stack
     * @return
     */
    private int get(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = get(stack);
            stack.push(result);
            return last;
        }
    }
}
