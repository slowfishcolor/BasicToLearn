package com.sfc.algorithms.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 有一棵二叉树，请设计一个算法，按照层次打印这棵二叉树。
 * 给定二叉树的根结点root，请返回打印结果，结果按照每一层一个数组进行储存，所有数组的顺序按照层数从上往下，且每一层的数组内元素按照从左往右排列。保证结点数小于等于500。
 *
 * Created by Prophet on 2017/8/15.
 */
public class TreePrinter {

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static int[][] printTree(TreeNode root) {
        // last 记录当前行的末尾节点，nlast 记录下一行的末尾节点, bfs 队列遍历
        Queue<TreeNode> queue = new LinkedList<>();
        // 保存当前层
        ArrayList<Integer> layer = new ArrayList<>();
        // 保存结果
        ArrayList<List<Integer>> resultList = new ArrayList<>();
        TreeNode last = root;
        TreeNode nlast = null;
        TreeNode node = root;
        queue.offer(root);
        while (!queue.isEmpty()) {
            node = queue.poll();
            layer.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
                nlast = node.left;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nlast = node.right;
            }
            if (last == node) {
                last = nlast;
                resultList.add(layer);
                layer = new ArrayList<>();
            }
        }

        // 转数组
        int[][] result = new int[resultList.size()][];
        int i = 0;
        for (List<Integer> list: resultList) {
            int[] temp = new int[list.size()];
            for (int j = 0; j < list.size(); j++) {
                temp[j] = list.get(j);
            }
            result[i++] = temp;
        }

        return result;
    }
}
