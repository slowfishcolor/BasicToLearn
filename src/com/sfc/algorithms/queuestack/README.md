# Queue & Stack

队列与栈相关的题目

## Queue

* FIFO
* `Queue<E>` 接口
* Queue用于模拟队列数据结构，采用“先进先出”的方式。Queue接口是继承了Collection的接口，
而Queue接口下面的实现类是PriorityQueue，继承的接口是Deque，接口Deque接口的实现类是ArrayDeque，
同时Deque还被LinkedList类实现。
* 方法 `offer()` `poll()` `peek()`

## Stack

* FILO
* `Stack<E>` 类
* 方法 `push()` `pop()` `peek()`


## 题目

* [Stack with Min](/src/com/sfc/algorithms/queuestack/StackWithMin.java) 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。

    * 法一，两个Stack，一个存数据，一个记录最小，只有要push进的元素 >= 当前最小时，才push进最小stack

    * 法二，两个Stack，一个存数据，一个记录最小，每次都push进当前最小元素，pop时依次pop即可
    
* [Two Stack](/src/com/sfc/algorithms/queuestack/TwoStack.java) 用两个栈实现一个队列

* [Two Stacks](/src/com/sfc/algorithms/queuestack/TwoStacks.java) 按升序对栈进行排序（即最大元素位于栈顶）
另外申请一个栈`help`来放降序的，之后再倒回去，放降序的时候栈顶一定最小，若不满足，把`help`中所有数`pop`到原栈，
压入最小值，再`push`会来

* [Stack Reverse](/src/com/sfc/algorithms/queuestack/StackReverse.java) 用递归实现栈的逆序 


* [Slide Window](/src/com/sfc/algorithms/queuestack/SlideWindow.java) 求滑动窗口中的最大值。
维护一个双端队列来保存可能是当前窗口中最大值的元素下标，队头放当前最大值下标。