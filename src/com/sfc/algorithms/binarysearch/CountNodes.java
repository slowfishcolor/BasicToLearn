package com.sfc.algorithms.binarysearch;

/**
 * 给定一棵完全二叉树的根节点root，返回这棵树的节点个数。如果完全二叉树的节点数为N，请实现时间复杂度低于O(N)的解法。
 * 给定树的根结点root，请返回树的大小。
 *
 * Created by Prophet on 2017/8/25.
 */
public class CountNodes {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    //1.先找到完全二叉树左子树最左边节点的层数。然后再找出右子树的左节点能到达的层数
    //2.看左右子树的左节点能到的层数相等，则左子树必定是一个满二叉树，那使用满二叉树的性质求出左子树的节点数，右子树的节点数使用递归方式求出
    //3.如果左右子树的左节点能到的层数不相等，则右子树必定是一颗少一层的满二叉树。然后左子树使用递归方法求出节点数
    public static int count(TreeNode root) {
        if (root == null) return 0;
        int l_LeftDepth = getDepth(root.left);  // 左孩子的左子树深度
        int r_LeftDepth = getDepth(root.right); // 右孩子的左子树深度
        if (l_LeftDepth == r_LeftDepth) {
            // 二者相等，说明左子树是满二叉树，其数目用公式 2^Depth - 1 求出，右子树递归求出
            // 返回：(2^leftDepth - 1) + 1 + count(rightNode)
            // 注：位运算的优先级比四则运算低，需要括号
            return (1 << l_LeftDepth) + count(root.right);
        } else {
            // 二者不相等，说明右子树是满二叉树，且 rightDepth = leftDepth + 1，右子树数目公式求，左子树递归求
            // 返回：(2^rightDepth - 1) + 1 + count(leftNode)
            return (1 << r_LeftDepth) + count(root.left);
        }
    }

    private static int getDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            root = root.left;
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
//        node2.left = node4;
//        node2.right = node5;
//        node3.left = node6;
        System.out.println(count(node1));
        System.out.println(1 << 1);
    }
}
