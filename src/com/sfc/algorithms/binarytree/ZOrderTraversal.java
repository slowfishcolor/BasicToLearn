package com.sfc.algorithms.binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的 Z 字遍历
 *
 * 使用两个 stack，分别存放当前处理层与下一层，放入时的顺序每换一层改变一次
 *
 * Created by Prophet on 2017/9/12.
 */
public class ZOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        // 每层结果
        List<Integer> layer = new LinkedList<>();
        // 当前处理层
        Stack<TreeNode> stack = new Stack<>();
        // 下个处理层
        Stack<TreeNode> nextStack = new Stack<>();
        stack.push(root);

        // 标识处理方向
        boolean flag = true;

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            layer.add(node.val);
            if (flag) {
                // 从左向右添加
                if (node.left != null) {
                    nextStack.push(node.left);
                }
                if (node.right != null) {
                    nextStack.push(node.right);
                }
            } else {
                // 从右向左添加
                if (node.right != null) {
                    nextStack.push(node.right);
                }
                if (node.left != null) {
                    nextStack.push(node.left);
                }
            }

            // 当前层已处理完成
            if (stack.isEmpty()) {
                // 存储改层
                result.add(layer);
                // 存储下一层
                layer = new LinkedList<>();
                // 交换 stack
                Stack<TreeNode> temp = stack;
                stack = nextStack;
                nextStack = temp;
                // 切换 flag
                flag = !flag;
            }
        }


        return result;
    }
}
