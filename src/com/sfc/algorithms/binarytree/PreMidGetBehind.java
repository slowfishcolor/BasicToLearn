package com.sfc.algorithms.binarytree;

/**
 * 已知树的前序中序，求后序
 *
 * 这类题的思路：通过前序或后序确定子树的 root，根据中序确定 root 的左右子树，之后递归求解建树
 *
 * <p>
 * Created by Prophet on 2017/9/11.
 */
public class PreMidGetBehind {

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 5, 3, 6, 7};
        int[] midOrder = {4, 2, 5, 1, 6, 3, 7};
        int[] behindOrder = getBehindFromPreMid(preOrder, midOrder);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < behindOrder.length; i++) {
            sb.append(behindOrder[i]);
            if (i != behindOrder.length - 1) sb.append(", ");
        }
        System.out.println(sb);
    }

    public static int[] getBehindFromPreMid(int[] preOrder, int[] midOrder) {
        TreeNode root = buildTree(preOrder, midOrder);
        int[] behindTraversal = new int[preOrder.length];
        int[] index = {0};
        getBehindTraversal(root, behindTraversal, index);
        return behindTraversal;
    }

    // 根据前序和中序，建立二叉树
    private static TreeNode buildTree(int[] preOrder, int[] midOrder) {
        // 前序的第一个，是子树的 root
        int value = preOrder[0];
        int length = preOrder.length;
        TreeNode root = new TreeNode(value);
        root.left = root.right = null;
        if (preOrder.length == 1) {
            return root;
        }
        int index = 0;
        // 在中序中定位 root，则左边是左子树，右边是右子树
        while (midOrder[index] != value)
            index++;// 此处还要考虑 index == length-1的情况
        if (index > 0) {
            // 中序中，根节点左边的节点都属于左子树
            // 左子树的前序遍历
            int[] leftSubPreOrder = new int[index];
            for (int i = 0; i < leftSubPreOrder.length; i++) {
                leftSubPreOrder[i] = preOrder[i + 1];
            }
            // 左子树的中序遍历
            int[] leftSubMidOrder = new int[index];
            for (int i = 0; i < leftSubMidOrder.length; i++) {
                leftSubMidOrder[i] = midOrder[i];
            }
            // 递归求解左子树
            root.left = buildTree(leftSubPreOrder, leftSubMidOrder);
        }

        // 存在右子树的情况下，同理递归求解右子树
        if (length - index - 1 > 0) {
            int[] rightSubMidOrder = new int[length - index - 1];
            for (int i = 0; i < rightSubMidOrder.length; i++) {
                rightSubMidOrder[i] = midOrder[i + index + 1];
            }
            int[] rightSubPreOrder = new int[length - index - 1];

            for (int i = 0; i < rightSubPreOrder.length; i++) {
                rightSubPreOrder[i] = preOrder[i + index + 1];
            }

            root.right = buildTree(rightSubPreOrder, rightSubMidOrder);
        }
        return root;
    }


    // 求后序遍历
    private static void getBehindTraversal(TreeNode root, int[] traversal, int[] index) {
        if (root == null) return;
        getBehindTraversal(root.left, traversal, index);
        getBehindTraversal(root.right, traversal, index);
        traversal[index[0]++] = root.val;
    }
}
