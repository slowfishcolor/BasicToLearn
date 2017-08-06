package com.sfc.algorithms.sort;

/**
 * Created by Prophet on 2017/2/18.
 */
public class QuickSortSimple {


    //交换数组位置
    private static void swapReference(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    /**
     * 返回index 为 left，right，center 中的中间值
     * 并且把三者中最小的放到left，最大的放到right，中间的放到 right-1
     * 相当与在返回pivot值的同时完成了一次比较与交换
     * quickSort在调用median3完成划分与枢纽元选择之后，进行逐步比较交换
     * 最后不要忘了把right-1 的 [pivot] 值与排序后位于中间位置的那个交换
     * 排序后位于中间位置的那个应该是大于pivot的
     * @param a
     * @param left
     * @param right
     */
    private static int median3(int[] a, int left, int right) {
        int center = (left + right) / 2;
        // 把三者中最小的放到left，最大的放到right，中间的放到center
//        if (a[center] < a[left])
//            swapReference(a, center, left);
//        if (a[right] < a[left])
//            swapReference(a, left, right);
//        if (a[center] > a[right])
//            swapReference(a, center, right);
        sort3(a, left,right);

        // 把中间的center放到right-1
        swapReference(a, center, right-1);
        return a[right-1];
    }

    /**
     * 快速排序内部算法
     * 通过median3 进行三数中值分割法，选取中枢pivot位置
     * 分别对pivot两边进行比较，把比pivot小的放到左边，比pivot大的放到右边
     * 之后对该quickSort进行递归调用，分割排序左右两边
     * @param a
     * @param left
     * @param right
     */
    private static void quickSort(int[] a, int left, int right) {
        // 递归终止条件
        if (right - left < 3) {
            sort3(a, left, right);
            return;
        }

        int pivot = median3(a, left, right);
        int i = left;
        int j = right-1;
        for (;;) {
            while (a[++i] < pivot){} // 找到当前左边比pivot大的第一个
            while (a[--j] > pivot){} // 找到当前右边比pivot小的第一个
            if (i < j)  // 终止条件
                swapReference(a, i, j); // 交换
            else
                break;
        }
        // 交换回去pivot
        swapReference(a, i ,right-1);

        quickSort(a, left, i-1); // 左边
        quickSort(a, i+1, right); // 右边
    }

    // 把left，right，center按照顺序交换
    private static void sort3(int[] a, int left, int right) {
        int center = (left + right)/2;
        if (a[left] > a[center])
            swapReference(a, left, center);
        if (a[right] < a[left])
            swapReference(a, left, right);
        if (a[right] < a[center])
            swapReference(a, center, right);
    }

    public static int[] sort(int[] a) {
        if (a == null || a.length < 2) return a;
        quickSort(a, 0, a.length - 1);
        return a;
    }

    public static void main(String args[]) {
        int[] array = {15, 12 ,13,12,11,10,9,8,7,6,5,4,3,2,1,0};
        sort(array);
    }

}








