package com.sfc.pointtooffer;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 方法，从右上角开始找
 *
 * Created by Prophet on 2017/9/17.
 */
public class N03FindInMatrix {

    public boolean Find(int target, int [][] array) {
        int rows = array.length;// 行数
        int columns = array[0].length;// 列数
        int r = 0;
        int c = columns - 1;
        while (r < rows && c >= 0) {
            // 比较二维数组中的元素与number的关系
            if (array[r][c] == target) {
                return true;
            } else if (array[r][c] > target) {
                // 列变小
                c--;
            } else {
                // 行变大
                r++;
            }
        }
        return false;
    }

}
