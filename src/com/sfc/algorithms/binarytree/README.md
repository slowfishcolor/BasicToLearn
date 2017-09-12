# Binary Tree

二叉树相关

## 问题们

* [Get Behind Traversal from pre and mid traversal](PreMidGetBehind.java)
通过前序中序遍历来求后序，通过前序确定子树的root，通过中序来确定左右子树，递归建树，之后后序遍历

* [Tree to Sequence](TreeToSequence.java)
二叉树的前序、中序、后序递归遍历

* [Tree height](TreeHeight.java)
求树的高度，递归求解

* [Serialize a tree](TreeToString.java)
序列化一个树

* [Tree printer](TreePrinter.java)
BFS 使用 `Queue` 按层打印 ，同时，每层结束要换行，`last` 记录当前行的末尾节点，`nlast` 记录下一行的末尾节点，`node = last` 时换行，同时 `last = nlast` 进行更新

* [DFS](DFS.java)
DFS, 使用递归与栈两种方式实现

* [Z Order Traversal](ZOrderTraversal.java)
二叉树的 Z 字遍历，使用两个 stack，分别存放当前处理层与下一层，放入时的顺序每换一层改变一次

