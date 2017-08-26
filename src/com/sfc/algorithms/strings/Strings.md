# 字符串类型题目

字符串题目，或者是可以转化为字符串相关思路的题目

* [IdenticalTree](/src/com/sfc/algorithms/strings/IdenticalTree.java) 对于两棵彼此独立的二叉树A和B，检查A中是否存在一棵子树与B树的拓扑结构完全相同。
将两个二叉树序列化为字符串后执行KMP

* [Transform](/src/com/sfc/algorithms/strings/Transform.java) 
 对于两个字符串A和B，如果A和B中出现的字符种类相同且每种字符出现的次数相同，则A和B互为变形词，判断两个字符串是否是变形次。
 方法：哈希后看是否相等，或者用 `int[256]` 代替哈希
 
* [Rotation](/src/com/sfc/algorithms/strings/Rotation.java) 判断旋转字符串，
令 `C = A + A`, `C.contains(B)` 即为结果