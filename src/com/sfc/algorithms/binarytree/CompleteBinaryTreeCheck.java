package com.sfc.algorithms.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 有一棵二叉树,请设计一个算法判断它是否是完全二叉树。
 *
 * 给定二叉树的根结点root，请返回一个bool值代表它是否为完全二叉树。树的结点个数小于等于500。
 *
 * Created by Prophet on 2017/8/18.
 */
public class CompleteBinaryTreeCheck {

    public static boolean checkCompleteBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode left;
        TreeNode right;
        // 按层遍历
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // 有右孩子没左孩子返回false
            if (node.left == null && node.right != null) {
                return false;
            }
            // 如果当前节点不是左右孩子都有，那么之后的节点必须都是叶节点
            if (node.left == null || node.right == null) {
                while (!queue.isEmpty()) {
                    TreeNode temp = queue.poll();
                    if (temp.left != null || temp.right != null) {
                        return false;
                    }
                }
            }
            // 继续遍历
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
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

        System.out.println("is complete binary tree: " + checkCompleteBinaryTree(node1));
    }
}
