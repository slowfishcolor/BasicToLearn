package com.sfc.algorithms.queuestack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 编写一个类,只能用两个栈结构实现队列,支持队列的基本操作(push，pop)。
 给定一个操作序列ope及它的长度n，其中元素为正数代表push操作，为0代表pop操作，
 保证操作序列合法且一定含pop操作，请返回pop的结果序列。
 测试样例：
 [1,2,3,0,4,0],6
 返回：[1,2]
 * Created by Prophet on 2017/2/16.
 */
public class TwoStack {

    Stack<Integer> pushStack = new Stack<>();
    Stack<Integer> popStack = new Stack<>();

    public int[] twoStack(int[] ope, int n) {
        // write code here
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (ope[i] != 0) {
                push(ope[i]);
            } else {
                resultList.add(pop());
            }
        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    private void push(int node) {
        pushStack.push(node);
    }

    private int pop() {
        int node = 0;
        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
        node = popStack.pop();
        while (!popStack.isEmpty()) {
            pushStack.push(popStack.pop());
        }
        return node;
    }
}
