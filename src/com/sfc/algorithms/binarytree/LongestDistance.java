package com.sfc.algorithms.binarytree;

/**
 * 从二叉树的节点A出发，可以向上或者向下走，但沿途的节点只能经过一次，当到达节点B时，
 * 路径上的节点数叫作A到B的距离。对于给定的一棵二叉树，求整棵树上节点间的最大距离。
 *
 * 给定一个二叉树的头结点root，请返回最大距离。保证点数大于等于2小于等于500.
 *
 * Created by Prophet on 2017/8/20.
 */
public class LongestDistance {

    public static int findLongest(TreeNode root) {
        int[] longest = new int[1];
        longest[0] = 0;
        int level = findLevel(root, longest);
        return longest[0];
    }

    /**
     * 遍历每个节点，找出以当前节点为根的最长路径，然后找出所有最长路径中的最大值。
     *
     * @param node
     * @param longest 存储节点最大距离
     * @return
     */
    private static int findLevel(TreeNode node, int[] longest) {
        if (node == null) {
            return 0;
        }
        int left = findLevel(node.left, longest);
        int right = findLevel(node.right, longest);
        longest[0] = Math.max(left + right + 1, longest[0]);
        return Math.max(left, right) + 1;
    }
}
