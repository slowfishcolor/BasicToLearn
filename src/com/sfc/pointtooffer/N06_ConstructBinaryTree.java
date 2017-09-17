package com.sfc.pointtooffer;

import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 *
 * Created by Prophet on 2017/9/17.
 */
public class N06_ConstructBinaryTree {

    public TreeNode reConstructBinaryTree(int [] pre,int [] mid) {
        // 前序的第一个，是子树的 root
        int value = pre[0];
        int length = pre.length;
        TreeNode root = new TreeNode(value);
        root.left = root.right = null;
        if (pre.length == 1) {
            return root;
        }
        int index = 0;
        // 在中序中定位 root，则左边是左子树，右边是右子树
        while (mid[index] != value)
            index++;// 此处还要考虑 index == length-1的情况
        if (index > 0) {
            // 中序中，根节点左边的节点都属于左子树
            // 左子树的前序遍历
            int[] leftSubPreOrder = Arrays.copyOfRange(pre, 1, index + 1);
            // 左子树的中序遍历
            int[] leftSubMidOrder = Arrays.copyOfRange(mid, 0, index);
            // 递归求解左子树
            root.left = reConstructBinaryTree(leftSubPreOrder, leftSubMidOrder);
        }

        // 存在右子树的情况下，同理递归求解右子树
        if (length - index - 1 > 0) {
            int[] rightSubMidOrder = Arrays.copyOfRange(mid, index + 1, mid.length);
            int[] rightSubPreOrder = Arrays.copyOfRange(pre, index + 1, pre.length);

            root.right = reConstructBinaryTree(rightSubPreOrder, rightSubMidOrder);
        }
        return root;
    }

}
