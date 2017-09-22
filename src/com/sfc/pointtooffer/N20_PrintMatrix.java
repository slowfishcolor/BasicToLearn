package com.sfc.pointtooffer;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 *
 * Created by Prophet on 2017/9/22.
 */
public class N20_PrintMatrix {
    public static ArrayList<Integer> printMatrix(int [][] matrix) {

        ArrayList<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length < 1 || matrix[0].length < 1)
            return result;

        int row = matrix.length;
        int col = matrix[0].length;

        // 四个边角打印的起始点
        int leftUp = 0;             // 左上 x
        int rightUp = 0;            // 右上 y
        int rightDown = col - 1;    // 右下 x
        int leftDown = row - 1;     // 左下 y

        while (leftUp <= rightDown && rightUp <= leftDown) {
            // 打印 左上 -> 右上
            for (int i = leftUp; i <= rightDown; i++) {
                result.add(matrix[rightUp][i]);
            }
            // 打印 右上 -> 右下
            for (int i = rightUp + 1; i <= leftDown; i++) {
                result.add(matrix[i][rightDown]);
            }
            if (rightUp != leftDown) {
                // 打印 右下 -> 左下
                for (int i = rightDown - 1; i >= leftUp ; i--) {
                    result.add(matrix[leftDown][i]);
                }
            }
            if (leftUp != rightDown) {
                // 打印 左下 -> 左上
                for (int i = leftDown - 1; i > rightUp ; i--) {
                    result.add(matrix[i][leftUp]);
                }
            }
            // 更新四个起始点
            leftUp++;
            rightUp++;
            rightDown--;
            leftDown--;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}};
        printMatrix(matrix);
    }
}
