# Binary Search

用二分搜索类算法题目

## 二分查找

* [BinarySearch](/src/com/sfc/algorithms/binarysearch/BinarySearch.java)
二分查找又称折半查找，它是一种效率较高的查找方法。
二分查找要求：1. 必须采用顺序存储结构 2. 必须按关键字大小有序排列。

* [FindLocalMiminum](/src/com/sfc/algorithms/binarysearch/FindLocalMinimum.java)
局部最小，找一个局部最小的坐标返回，一个极小值点

* [LeftMostAppearance](/src/com/sfc/algorithms/binarysearch/LeftMostAppearance.java)
有序数组，第一个出现目标值的下标，二分查找，相等的时候更新 res = mid，并继续向左查找

* [CountNodes](/src/com/sfc/algorithms/binarysearch/CountNodes.java)
求一个完全二叉树的节点数目，满二叉树的数目 2^Depth - 1，通过求左右孩子的最左深度，判断左右子树是不是完全二叉树，是的那个子树通过公式计算数目，不是的那个子树通过递归计算数目，最后相加即可

