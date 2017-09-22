package com.sfc.pointtooffer;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * 遍历的同时交换非叶子节点的左右子节点
 *
 * Created by Prophet on 2017/9/22.
 */
public class N19_MirrorOfBinaryTree {
    public class Solution {
        public void Mirror(TreeNode root) {

            if (root == null)
                return;
            if (root.left == null && root.right == null)
                return;

            // 交换非叶子节点的左右子树
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            // 递归交换左右子树
            Mirror(root.left);
            Mirror(root.right);
        }
    }
}
