package com.sfc.pointtooffer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * 可以使用双指针的方式，一个指针指向数组的开始，一个指针指向数组的尾部，
 * 如果头部的数为偶数且尾部的数是奇数则交换，否则头部指针向后移动，尾部指针向前移动，直到两个指针相遇
 *
 * 该方法不稳定
 *
 * Created by Prophet on 2017/9/21.
 */
public class N14_ReorderArray {

    // 前后双指针，不稳定，无法满足顺序不变
    public void reOrderArray(int [] array) {
        if (array == null) return;
        int l = 0;
        int r = array.length - 1;
        while (l < r) {
            while (array[l] % 2 != 0 && l < r) {
                l++;
            }
            while (array[r] % 2 == 0 && l < r) {
                r--;
            }
            if (l < r) {
                int t = array[l];
                array[l] = array[r];
                array[r] = t;
            }
        }
    }

    // 插入排序思想
    public void reOrderArray2(int [] array) {
        if (array == null) return;
        for (int i = 0; i < array.length; i++) {
            int t = array[i];
            if (t % 2 == 1) {
                int j = i;
                for ( ; j >= 1 && array[j - 1] % 2 == 0; j--) {
                    array[j] = array[j - 1];
                }
                array[j] = t;
            }
        }
    }
}
