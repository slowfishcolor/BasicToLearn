package com.sfc.pointtooffer;

/**
 * 输入一个链表，反转链表后，输出链表的所有元素。
 *
 * Created by Prophet on 2017/9/21.
 */
public class N16_ReverseList {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode next = head.next;
        ListNode p = next;
        pre.next = null;    // 尾巴
        while (p.next != null) {
            next = p.next;  // 保护第三个
            p.next = pre;   // 调换 p -> pre
            pre = p;        // pre p 前进
            p = next;
        }
        p.next = pre;       // 头
        return p;
    }
}
