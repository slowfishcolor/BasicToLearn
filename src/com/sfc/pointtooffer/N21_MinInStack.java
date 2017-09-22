package com.sfc.pointtooffer;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 *
 * Method 1: 两个 Stack，一个存数据，一个记录最小，只有要 push 进的元素 >= 当前最小时，才 push 进最小 stack
 *
 * Method 2: 两个 Stack，一个存数据，一个记录最小，每次都 push 进当前最小元素， pop 时依次 pop 即可
 *
 * Created by Prophet on 2017/9/22.
 */
public class N21_MinInStack {

    private Stack<Integer> dataStack= new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    int curMin = Integer.MAX_VALUE;

    public void push(int node) {
        dataStack.push(node);
        if (node <= curMin) {
            minStack.push(node);
            curMin = node;
        }
    }

    public void pop() {
        if (dataStack.peek() == curMin) {
            minStack.pop();
        }
        dataStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
