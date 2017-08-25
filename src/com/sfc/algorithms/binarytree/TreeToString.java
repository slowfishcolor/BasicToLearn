package com.sfc.algorithms.binarytree;

/**
 * 首先我们介绍二叉树先序序列化的方式，假设序列化的结果字符串为str，初始时str等于空字符串。
 * 先序遍历二叉树，如果遇到空节点，就在str的末尾加上“#!”，“#”表示这个节点为空，节点值不存在，
 * 当然你也可以用其他的特殊字符，“!”表示一个值的结束。如果遇到不为空的节点，假设节点值为3，
 * 就在str的末尾加上“3!”。现在请你实现树的先序序列化。
 *
 * 给定树的根结点root，请返回二叉树序列化后的字符串。
 *
 * Created by Prophet on 2017/8/25.
 */
public class TreeToString {

    public static String toString(TreeNode root) {
        // write code here
        StringBuffer sb = new StringBuffer();
        serialize(root, sb);
        return sb.toString();
    }

    // 前序遍历
    private static void serialize(TreeNode root, StringBuffer sb) {
        if (root == null) {
            sb.append("#!");
            return;
        }
        sb.append(root.val);
        sb.append("!");
        serialize(root.left, sb);
        serialize(root.right, sb);
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

        System.out.println(toString(node1));
    }
}
