package com.sfc.algorithms.binarysearch;

/**
 * 对于一个有序循环数组arr，返回arr中的最小值。有序循环数组是指，有序数组左边任意长度的部分放到右边去，
 * 右边的部分拿到左边来。比如数组[1,2,3,3,4]，是有序循环数组，[4,1,2,3,3]也是。
 *
 * 给定数组arr及它的大小n，请返回最小值。
 *
 * Created by Prophet on 2017/8/24.
 */
public class MinValue {

    public static int getMin(int[] arr, int n) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = n - 1;
        int mid = 0;
        while (left < right) {
            if(left == right - 1) {
                break;
            }
            if (arr[left] < arr[right]) { // 有序，并且没有循环移动过
                return arr[left];
            }
            mid = (left + right) / 2;
            if (arr[left] > arr[mid]) { // 发生了循环移动，而且可以锁定在左边部分
                right = mid;
                continue;
            }
            if (arr[mid] > arr[right]) { // 发生了循环移动，而且可以锁定在右边部分
                left = mid;
                continue;
            }


        }
        return Math.min(arr[left], arr[right]);
    }
}
