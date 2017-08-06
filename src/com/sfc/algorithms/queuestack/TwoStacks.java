package com.sfc.algorithms.queuestack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），
 * 要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。
 * Created by Prophet on 2017/2/17.
 */
public class TwoStacks {
    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        // write code here
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numbers.length; i++) {
            stack.push(numbers[i]);
        }
        Stack<Integer> temp = new Stack<>();
        for (int i = 0; i < numbers.length; i++) {
            sortMin(stack, temp, i, numbers.length);
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    /**
     * 有 n 个元素的栈中，对 index 到 n 个元素进行调整，将最小值移动到index位置
     * 保证第 index 位置为 index 到最后一个位置中的最小值
     * @param stack
     * @param index
     * @param n
     */
    private void sortMin(Stack<Integer> stack, Stack<Integer> temp, int index, int n) {
        int min = stack.peek();
        for (int i = index; i < n; i++) {
            int t = stack.pop();
            min = Math.min(min, t);
            temp.push(t);
        }

        // 压入最小元素
        stack.push(min);

        // 当有两个相等的最小元素时，保证只弹出一个
        boolean flag = true;
        for (int i = index; i < n; i++) {
            int t = temp.pop();
            if (t == min) {
                if (flag) {
                    temp.pop(); // 删除temp最小元素
                    flag = false;
                }
            } else {
                stack.push(temp.pop());
            }
        }
    }
}
