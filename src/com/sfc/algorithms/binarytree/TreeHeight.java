package com.sfc.algorithms.binarytree;

/**
 * 获取二叉树的深度
 *
 * Created by Prophet on 2017/8/18.
 */
public class TreeHeight {

    public static int getHeight(TreeNode head, int level) {

        // 如果当前 head 为空，则返回当前所到达的深度
        if (head == null) {
            return level;
        }

        // 获得以当前 head 为头的左子树深度
        int LH = getHeight(head.left, level + 1);

        // 获得以当前 head 为头的右子树深度
        int RH = getHeight(head.right, level + 1);

        // 最后返回当前以 head 为头的深度
        return Math.max(LH, RH);
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

        System.out.println("Height: " + getHeight(node1, 0));
    }
}
