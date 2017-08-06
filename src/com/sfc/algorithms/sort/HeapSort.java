package com.sfc.algorithms.sort;

/**
 * Created by Prophet on 2017/2/19.
 */
public class HeapSort {

    /**
     * percolate down
     * 调整堆序
     * 将元素 A[index]逐步从上往下调整，进行下滤操作，交换至合适的位置，维持堆序
     * @param A 除了index 位置的元素外，已经满足堆序的数组
     * @param index 要调整元素的位置
     * @param length 调整的结尾index
     */
    private static void adjustHeap(int[] A, int index, int length) {
        int child;
        int temp = A[index];
        for (; index*2 + 1 < length; index = child) {
            child = index*2 + 1;
            // 1. 找出孩子节点中大的一个
            if (child != length - 1 && A[child] < A[child + 1]) {
                child++;    // 如果left child 小于 right child，则跟right child 比较, 目的是找最大的child
            }
            // 2. 判断是否满足堆序性，不满足的话，继续向下找，直到找到合适的位置
            if (temp > A[child]) {
                break;  // 如果A[index] > A[child] 则满足堆序性，停止比较
            } else {
                // 不满足堆序则继续向下比较
                A[index] = A[child];
                index = child;
            }
        }
        // 3. 放到合适的位置
        A[index] = temp;    // 调整至合适位置
    }

    /**
     * 建堆，将数组A中的元素建堆
     * @param A
     */
    private static void buildHeap(int[] A) {

        // 从倒数第二层开始，从下往上进行下滤操作，因为最后一层都是叶子
        for (int i = A.length / 2; i >= 0; i--) {
            adjustHeap(A, i, A.length);
        }
    }

    public static int[] heapSort(int[] A) {
        // 建大根堆
        buildHeap(A);
        // 把A[0]元素与A[i]元素交换，这样保证当前堆的最大元素在堆的后一个位置
        // 交换后，相当于原来的A[i]插入到了length - i的堆中的第一个元素
        // 所以要对该元素进行下滤调整到应该存在的位置，维持堆序
        for (int i = A.length - 1; i > 0; i--) {
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            adjustHeap(A, 0, i);
        }
        return A;
    }

    public static void main(String[] args) {
//        heapSort(new int[]{54,35,48,36,27,12,44,44,8,14,26,17,28});
        heapSort(new int[]{4,2});
    }

}
