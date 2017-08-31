package com.sfc.algorithms.queuestack;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * 有一个整型数组 arr 和一个大小为 w 的窗口从数组的最左边滑到最右边,窗口每次向右边滑一个位置。
 * 返回一个长度为n-w+1的数组res，res[i]表示每一种窗口状态下的最大值。 以数组为[4,3,5,4,3,3,6,7]，w=3为例。
 * 因为第一个窗口[4,3,5]的最大值为5，第二个窗口[3,5,4]的最大值为5，第三个窗口[5,4,3]的最大值为5。
 * 第四个窗口[4,3,3]的最大值为4。第五个窗口[3,3,6]的最大值为6。第六个窗口[3,6,7]的最大值为7。
 * 所以最终返回[5,5,5,4,6,7]。

 给定整形数组arr及它的大小n，同时给定w，请返回res数组。保证w小于等于n，同时保证数组大小小于等于500。

 测试样例：
 [4,3,5,4,3,3,6,7],8,3
 返回：[5,5,5,4,6,7]

 思路，维护一个双端队列来保存可能是当前窗口中最大值的元素下标，队头放当前最大值下标

 采用双端队列是因为要对队头和队尾进行更新：
 1.队头存放当前最大值的下标；
 2.对队头的更新是为了确保队头仍然包含在窗口内；
 3.对队尾的更新是为了确保信息的充分性。


 *
 * Created by Prophet on 2017/8/31.
 */
public class SlideWindow {

    public static int[] slide(int[] arr, int n, int w) {

        if (arr == null || arr.length < w) {
            return null;
        }

        int[] res = new int[arr.length - w + 1];

        Deque<Integer> deque = new LinkedList<>();

        // 队头存放最大值下标
        // 队头更新：队头存放最大值，如果当前队头不在窗口范围，则弹出队头
        // 队尾更新：如果队尾元素小于当前值，也就意味着最新的元素更大，所以删除掉小于最新元素的历史元素
        // 队尾插入：如果队头的最大元素大于等于当前元素，意味着当前元素有可能成为接下来的最大元素，因此队尾插入当前元素下标
        for (int i = 0; i < arr.length; i++) {
            // 队头更新
            // 对队头的更新是为了确保队头仍然包含在窗口内
            // 队头存放最大值下标，如果当前队头不在窗口范围，则弹出队头
            if (!deque.isEmpty() && deque.peekFirst() <= i - w) {
                deque.pollFirst();  // 弹出队头
            }
            // 队尾更新
            // 对队尾的更新是为了确保信息的充分性，即存入未来可能是最大值的元素下标
            // 如果队尾元素小于当前值，也就意味着最新的元素更大，所以删除掉小于最新元素的历史元素
            // 一直删除到队列为空，或者发现第一个大于等于当前元素的元素
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();   // 弹出队尾
            }
            // 队尾插入
            // 如果队头的最大元素大于等于当前元素，意味着当前元素有可能成为接下来的最大元素，因此队尾插入当前元素下标
            if (deque.isEmpty() || arr[deque.peekFirst()] >= arr[i]) {
                deque.offerLast(i);
            }
            // 更新 res
            // 在窗口范围时，存入队头元素下标对应的元素值
            if (i >= w - 1) {
                res[i - w + 1] = arr[deque.peekFirst()];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,5,4,3,3,6,7};
        slide(nums, nums.length, 3);
    }

}
