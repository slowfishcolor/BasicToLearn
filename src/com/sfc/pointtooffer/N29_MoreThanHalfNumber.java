package com.sfc.pointtooffer;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 * 超过数组长度的一半，因此输出2。如果不存在则输出0。
 * <p>
 * 数组中有一个数字出现的次数超过数组长度的一半，则排序后，数组中间的数即为所求
 *
 * 思路一，Partition 算法可以求得任意第 k 大的数，这里求第 n/2 大的数
 * <p>
 * Created by Prophet on 2017/9/22.
 */
public class N29_MoreThanHalfNumber {


    public int MoreThanHalfNum_Solution(int[] array) {
        if (array.length <= 0)
            return 0;

        int start = 0;
        int length = array.length;
        int end = length - 1;
        int middle = length >> 1;

        int index = partition(array, start, end);
        while (index != middle) {
            if (index > middle) {
                index = partition(array, start, index - 1);
            } else {
                index = partition(array, index + 1, end);
            }
        }
        int result = array[middle];
        int times = 0;
        for (int i = 0; i < length; ++i) {
            if (array[i] == result)
                times++;
        }
        if (times * 2 < length) {
            return 0;
        } else {
            return result;
        }
    }

    private int partition(int[] array, int start, int end) {
        int flag = (array[start] + array[end]) / 2;
        while (start < end) {
            while (array[end] > flag) {
                end--;
            }
            swap(array, start, end);
            while (array[start] <= flag) {
                start++;
            }
            swap(array, start, end);
        }
        return start;
    }

    private void swap(int[] array, int a, int b) {
        int t = array[a];
        array[a] = array[b];
        array[b] = t;
    }
}
