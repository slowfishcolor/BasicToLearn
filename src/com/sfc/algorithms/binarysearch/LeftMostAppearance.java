package com.sfc.algorithms.binarysearch;

/**
 * 对于一个有序数组arr，再给定一个整数num，请在arr中找到num这个数出现的最左边的位置。
 * 给定一个数组arr及它的大小n，同时给定num。请返回所求位置。若该元素在数组中未出现，请返回-1。
 *
 * Created by Prophet on 2017/8/23.
 */
public class LeftMostAppearance {

    public static int findPos(int[] arr, int n, int num) {

        if(arr == null || n == 0){
            return -1;
        }

        int res = -1;
        int left = 0;
        int right = arr.length;
        int mid = 0;

        /*while (left <= right) {
            if (arr[left] == num) {
                res = left;
                break;
            }
            mid = left + (right - left) / 2;
            if (arr[mid] == num) {
                right = mid;
            } else if (arr[mid] < num) {
                left = mid + 1;
            } else  {
                right = mid - 1;
            }
        }*/

        while (left <= right) {
            mid = left + (right - left) / 2;
            // 相等时更新 res 并继续在左边找
            if (arr[mid] == num) {
                res = mid;
                right = mid - 1;
            } else if (arr[mid] < num) {
                left = mid + 1;
            } else  {
                right = mid - 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,4};
        System.out.println(findPos(arr, 5, 3));
    }

}
