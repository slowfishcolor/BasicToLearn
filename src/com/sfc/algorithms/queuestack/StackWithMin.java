package com.sfc.algorithms.queuestack;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 *
 * 法一，两个Stack，一个存数据，一个记录最小，只有要push进的元素 >= 当前最小时，才push进最小stack
 * 法二，两个Stack，一个存数据，一个记录最小，每次都push进当前最小元素，pop时依次pop即可，如下
 *
 * Created by Prophet on 2017/2/16.
 */
public class StackWithMin {

    private Stack<Integer> dataStack= new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<>();

    int currentMin = Integer.MAX_VALUE;

    public void push(int node) {
        dataStack.push(node);
        if (currentMin > node) {
            currentMin = node;
        }
        minStack.push(currentMin);

    }

    public void pop() {
        dataStack.pop();
        currentMin = minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
