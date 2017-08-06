package com.sfc.algorithms.sort;

/**
 * 冒泡排序
 *  冒泡排序，从左到右依次判断相邻的两元素的大小如果左边的比右边的大，则交换位置。
 *  这样一次从左到右的遍历就能得到一个为排序队列中的最大值。
 *  然后将这个最大值放置到数组的右侧。因为未完成排序的元素越来越少，
 *  那么当所有元素都以完成排序时，循环结束。这里需要一个两侧的循环机制，
 *  算法耗时:O(N*N)。
 * Created by Prophet on 2017/2/12.
 */
public class BubbleSort {
    public static void main(String[] args) {
        bubbleSort(new int[] {1, 6, 2, 7, 3});

    }

    public static int[] bubbleSort(int[] array) {
        if (array.length < 2) return array;
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
