package com.sfc.pointtooffer;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * Created by Prophet on 2017/9/21.
 */
public class N17_MergeSortedLists {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        // 把没处理完的链表连到最后
        if (list1 != null) p.next = list1;
        if (list2 != null) p.next = list2;
        return dummy.next;
    }
}
