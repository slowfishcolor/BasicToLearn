package com.sfc.algorithms.sort;

/**
 * 归并排序，分而治之，先分割，然后通过两两合并来治
 *
 * Created by Prophet on 2017/9/9.
 */
public class MergeSort {


    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        // 在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
    }

    /**
     * 通过递归进行分治
     * @param arr   待排序的数组
     * @param left  要排序部分的开始坐标
     * @param right 要排序部分的结束坐标
     * @param temp  临时数组
     */
    private static void sort(int[] arr, int left, int right, int[] temp){
        if(left < right){
            int mid = left + (right - left) / 2;
            sort(arr,left,mid,temp);        //左边归并排序，使得左子序列有序
            sort(arr,mid+1,right,temp); //右边归并排序，使得右子序列有序
            merge(arr,left,mid,right,temp); //将两个有序子数组合并操作
        }
    }

    /**
     * 合并两个相邻有序数组
     * @param arr   要合并的数组
     * @param left  合并数组 1 的开始
     * @param mid   合并数组 1 的结束
     * @param right 合并数组 2 的结束
     * @param temp  临时数组
     */
    private static void merge(int[] arr, int left, int mid, int right, int[] temp){
        int i = left;   //左序列指针
        int j = mid + 1;  //右序列指针
        int t = 0;      //临时数组指针
        // 合并到 temp 数组中
        while (i <= mid && j <= right){
            if(arr[i] <= arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        // 将左边剩余元素填充进temp中
        while(i <= mid){
            temp[t++] = arr[i++];
        }
        // 将右序列剩余元素填充进temp中
        while(j <= right){
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 2, 3};
        mergeSort(array);
    }

}
