package com.sfc.algorithms.sort;

/**
 * 快速排序
 * Created by Prophet on 2017/2/13.
 */
public class QuickSort {

    public static int CUTTOFF = 10;

    /**
     *
     * @param array 待排序数组
     * @param left  数组起始index
     * @param right 数组结束index
     */
    public static void quickSort(int[] array, int left, int right) {
        // 参数检查
        if (array == null || array.length < 2 || left >= right) return;

        if (left + CUTTOFF <= right) {

            // 取中枢值，同时把中枢值放到倒二 right-1，小的放最前 left，大的放最后 right
            int pivot = median3(array, left, right);

            // 开始分割
            int i = left;
            int j = right -1;
            for(;;) {
                // 找到第一个大于中枢值的index
                while (array[++i] < pivot) {}
                // 找到第一个小于中枢值的index
                while (array[--j] > pivot) {}
                if (i < j)
                    swapReference(array, i, j);
                else
                    break;
            }

            //因为在寻找中值将中值交换到了endIndex-1的位置
            //所以在一轮比较过后，要将中值交换回到下标相交位置
            swapReference(array, i, right -1);

            // 此时小于 pivot 的都在前半部分，大于的都在后半部分
            // 排序小的部分
            quickSort(array, left, i - 1);
            //  排序大的部分
            quickSort(array, i + 1, right);

        }
        else {
            // 带分割长度小于CUTTOFF，使用插入排序
            insertionSort(array, left, right);
        }
    }

    //交换数组位置
    private static void swapReference(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
    //取数组中值,并将中值转移到倒数第二位置
    private static int median3(int[] a, int left, int right) {
        int center = (left + right) / 2;
        if (a[left] > a[center]) {
            swapReference(a, left, center);
        }
        if (a[left] > a[right]) {
            swapReference(a, left, right);
        }
        if (a[center] > a[right]) {
            swapReference(a, center, right);
        }
        // 把中枢 pivot 放到 right - 1 的位置
        swapReference(a, center, right - 1);
        return a[right - 1];
    }
    // 插入排序
    public static void insertionSort(int[] array, int left, int right) {
        if (right <= left) return;
        // i, 剩余待比较的元素位置
        for (int i = left + 1; i <= right; i++) {
            // 保存元素到临时变量，腾出位置
            int temp = array[i];
            int j = i;
            // j：从后往前比较已经排序过的数据，若小于 temp，则右移
            // >= 是因为第一次是 比较的 array[i] = array[j], 必然相等
            for (j = i; j > 0 && array[j] > temp; j-- ) {
                array[j] = array[j - 1];
            }
            array[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {15, 12 ,13,12,11,10,9,8,7,6,5,4,3,2,1,0};
        quickSort(array, 0, array.length - 1);
        int a = 0;
    }
}
