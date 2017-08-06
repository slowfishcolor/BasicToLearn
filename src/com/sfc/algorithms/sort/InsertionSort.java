package com.sfc.algorithms.sort;

/**
 * 插入排序
 * 从第一个元素开始，该元素可以认为已经被排序
 取出下一个元素，在已经排序的元素序列中从后向前扫描
 如果该元素（已排序）大于新元素，将该元素移到下一位置
 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
 将新元素插入到该位置后
 重复步骤2~5
 * Created by Prophet on 2017/2/12.
 */
public class InsertionSort {
    public static void main(String[] args) {
        insertionSort(new int[]{4, 2, 1, 7, 5});
    }
    public static int[] insertionSort(int[] array) {
        // i, 剩余待比较的元素位置
        for (int i = 0; i < array.length; i++) {
            // 保存元素到临时变量，腾出位置
            int temp = array[i];
            int j = i;
            // j：从后往前比较已经排序过的数据，若小于 temp，则右移
            // >= 是因为第一次是 比较的 array[i] = array[j], 必然相等
            for (j = i; j > 0 && array[j] >= temp; j-- ) {
                array[j] = array[j - 1];
            }
            array[j] = temp;
        }
        return array;
    }

    public int[] insertionSort(int[] A, int n) {
        int i, j, temp;

        for(i = 1; i < n; i++){
            temp = A[i];
            for(j = i; j > 0 && A[j - 1] > temp; j-- ){
                A[j] = A[j - 1];
            }
            A[j] = temp;
        }

        return A;
    }
}
