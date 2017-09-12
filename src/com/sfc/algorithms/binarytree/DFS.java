package com.sfc.algorithms.binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的 DFS 遍历
 *
 * Created by Prophet on 2017/9/11.
 */
public class DFS {

    // 先序递归
    public static List<Integer> dfsRecursive(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        dfsRecursive(root, list);
        return list;
    }

    private static void dfsRecursive(TreeNode node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        dfsRecursive(node.left, list);
        dfsRecursive(node.right, list);
    }

    // 使用 Stack 迭代
    // 将左子树点不断的压入栈，直到 null，然后处理栈顶节点的右子树
    public static List<Integer> dfsIterative(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        // node != null 是防止 stack 空时 right 节点不为空，要继续
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                // 先访问再入栈
                list.add(node.val);
                node = node.left;
                if (node != null)
                    stack.push(node);
            }
            node = stack.pop();
            node = node.right;
        }
        return list;
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

        List<Integer> list_1 = dfsRecursive(node1);

        StringBuffer sb = new StringBuffer();
        for (Integer i: list_1) {
            sb.append(i);
            sb.append(",");
        }
        System.out.println(sb);

        List<Integer> list_2 = dfsIterative(node1);

        sb = new StringBuffer();
        for (Integer i: list_2) {
            sb.append(i);
            sb.append(",");
        }
        System.out.println(sb);
    }
}
