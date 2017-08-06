package com.sfc.algorithms;

/**
 * 二分查找又称折半查找，它是一种效率较高的查找方法。
 * 【二分查找要求】：1.必须采用顺序存储结构 2.必须按关键字大小有序排列。
 * Created by Prophet on 2017/2/12.
 */
public class BinarySerch {
    public static void main(String[] args) {
        int[] src = new int[] {1, 3, 5, 7, 8, 9};
        System.out.println(binarySearch(src, 3));
        System.out.println(binarySearch(src, 3, 0, src.length));
    }

    /**
     *  迭代解决
     *  时间复杂度O(logN)
     * @param sortArray 有序数组
     * @param des 要查找的元素
     * @return 元素的下标
     */
    public static int binarySearch(int[] sortArray, int des) {
        int low = 0;
        int high = sortArray.length;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (des == sortArray[middle]) {
                return middle;
            } else if (des < sortArray[middle]) {
                // 不减一的话可能会存在下标不移动的情况
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 递归解决
     * @param sortArray
     * @param des
     * @param begin 开始的下标
     * @param end 结束的下标
     * @return
     */
    public static int binarySearch(int[] sortArray, int des, int begin,int end) {
        int mid = begin + (end - begin) / 2;
        if (sortArray[mid] == des) return mid;
        if (begin >= end) {
            return -1;
        } else if (sortArray[mid] < des) {
            return binarySearch(sortArray, des, mid + 1, end);
        } else if (sortArray[mid] > des) {
            return binarySearch(sortArray, des, begin, mid - 1);
        }
        return -1;
    }

}
