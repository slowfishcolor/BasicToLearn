package com.sfc.pointtooffer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，
 * 输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * Created by Prophet on 2017/9/17.
 */
public class N08_MinNumberInRotatedArray {
    public int minNumberInRotateArray(int [] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
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
            }


        }
        return Math.min(arr[left], arr[right]);
    }
}
