package com.sfc.pointtooffer;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * 其实可以序列化后进行 contains 比较
 *
 * Created by Prophet on 2017/9/21.
 */
public class N18_SubstructureInTree {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        // 当 Tree1 和 Tree2 都不为 null 的时候，才进行比较。否则直接返回 false
        if (root1 != null && root2 != null) {
            // 如果找到了对应 Tree2 的根节点的点
            if (root1.val == root2.val) {
                // 以这个根节点为为起点判断是否包含 Tree2
                result = doesTree1HavaTree2(root1, root2);
            }
            // 如果找不到，那么就再去 root 的左儿子当作起点，去判断时候包含 Tree2
            if (!result)
                result = doesTree1HavaTree2(root1.left, root2);
            // 如果还找不到，那么就再去 root 的右儿子当作起点，去判断时候包含 Tree2
            if (!result)
                result = doesTree1HavaTree2(root1.right, root2);
        }
        return result;
    }

    private boolean doesTree1HavaTree2(TreeNode root1,
                                       TreeNode root2) {
        if (root2 == null) {    // Tree2 已遍历完，true
            return true;
        } else if (root1 == null)   // Tree2 未遍历完 Tree1 已遍历完，false
            return false;
        // 相等的话往下继续比较左右子树
        if(root1.val != root2.val) {
            return false;
        }
        return doesTree1HavaTree2(root1.left, root2.left)&&
                doesTree1HavaTree2(root1.right, root2.right);
    }
}
