package com.sfc.pointtooffer;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * 使用双指针的方式，前一个指针先走 k 步(中间隔 k-1 个结点)，后一个指针才开始走，直到第一个指针走到尾，
 * 后一个指针指向的就是要找的倒数第 k 个数。
 * 值得注意的是：1、k 是否超过链表长度且 k 必须为正整数；2、链表是否为空。
 *
 * Created by Prophet on 2017/9/21.
 */
public class N15_KthNodeFromEnd {
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k <= 0) {
            return null;
        }

        ListNode p = head;
        ListNode q = head;

        for (int i = 0; i < k - 1; i++) {
            if (q.next != null) {
                q = q.next;
            } else {
                return null;
            }
        }

        while (q.next != null) {
            p = p.next;
            q = q.next;
        }

        return p;
    }
}
