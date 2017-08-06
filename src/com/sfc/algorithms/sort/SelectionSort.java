package com.sfc.algorithms.sort;

/**
 * 选择排序
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置；
 * 然后，再从剩余未排序元素中继续寻找最小（大）元素，放到已排序序列的末尾。
 * Created by Prophet on 2017/2/12.
 */
public class SelectionSort {
    public static void main (String[] args) {
        selectionSort(new int[]{2, 1, 7, 6, 4});
    }
    public static int[] selectionSort(int[] array) {
        if (array.length < 2) return array;
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int index = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    index = j;
                }
            }
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
        return array;
    }
}
