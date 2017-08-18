package com.sfc.algorithms.binarytree;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * 请用递归方式实现二叉树的先序、中序和后序的遍历打印。
 *
 * 给定一个二叉树的根结点root，请依次返回二叉树的先序，中序和后续遍历(二维数组的形式)
 *
 * Created by Prophet on 2017/8/13.
 */
public class TreeToSequence {

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static int[][] convert(TreeNode root) {
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        List<Integer> list3 = new LinkedList<>();
        traversal_1(root, list1);
        traversal_2(root, list2);
        traversal_3(root, list3);
        int[][] result = new int[3][list1.size()];
        for (int i = 0; i < list1.size(); i++) {
            result[0][i] = list1.get(i);
            result[1][i] = list2.get(i);
            result[2][i] = list3.get(i);
        }
        return result;
    }

    private static void traversal_1(TreeNode root, List<Integer> list) {
        // 先序遍历
        if (root == null) {
            return;
        }
        list.add(root.val);
        traversal_1(root.left, list);
        traversal_1(root.right, list);
    }

    private static void traversal_2(TreeNode root, List<Integer> list) {
        // 中序遍历
        if (root == null) {
            return;
        }
        traversal_2(root.left, list);
        list.add(root.val);
        traversal_2(root.right, list);
    }

    private static void traversal_3(TreeNode root, List<Integer> list) {
        // 后序遍历
        if (root == null) {
            return;
        }
        traversal_3(root.left, list);
        traversal_3(root.right, list);
        list.add(root.val);
    }

    public static void main(String args[]) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;

        int[][] result = convert(node1);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
