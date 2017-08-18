package com.sfc.algorithms.binarytree;

/**
 * 判断一棵树是不是 AVL 平衡二叉树
 * 1. 空树  2. 所有子数的左子树与右子树高度相差不超过一
 * Created by Prophet on 2017/8/18.
 */
public class CheckAVL {

    public static boolean check_1(TreeNode root) {
        boolean[] res = new boolean[1];
        res[0] = true;
        int level = 0;
        getHeight(root, level, res);// 获得以根结点为头的深度
        return res[0];
    }

    private static int getHeight(TreeNode head, int level, boolean[] res) {

        // 如果当前 head 为空，则返回当前所到达的深度
        if (head == null) {
            return level;
        }

        // 获得以当前 head 为头的左子树深度
        int LH = getHeight(head.left, level + 1, res);

        // 如果以当前 head 为头的左子树不是 AVL，直接返回当前所到达的深度
        if (!res[0]) {
            return level;
        }

        // 获得以当前 head 为头的右子树深度
        int RH = getHeight(head.right, level + 1, res);

        // 如果以当前 head 为头的右子树不是 AVL，直接返回当前所达到的深度
        if (!res[0]) {
            return level;
        }

        // 比较以当前 head 为头的左子树深度和右子树深度，如果其相差大于 1，则说明以当前 head 为头的二叉树不是 AVL
        if (Math.abs(LH - RH) > 1) {
            res[0] = false;
        }

        // 最后返回当前以 head 为头的深度
        return Math.max(LH, RH);
    }

    public static boolean check_2(TreeNode root) {
        return check(root) >= 0 ;
    }

    private static int check(TreeNode root) {
        if (root == null) return 0;
        // 后序遍历，先左右递归，再处理当前
        int left = check(root.left);
        int right = check(root.right);
        // 中止条件 1
        if (left < 0 || right < 0 ) return -1;
        // 非平衡
        if (Math.abs(left - right) > 1) return -1;
        // 返回最大子树深度
        return left > right ? left + 1: right + 1;
    }
}
