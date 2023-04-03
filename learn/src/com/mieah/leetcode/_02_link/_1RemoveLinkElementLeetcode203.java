package com.mieah.leetcode._02_link;

import java.util.Random;

public class _1RemoveLinkElementLeetcode203 {


    static class ListNode {
        int val;

        ListNode next;

        public ListNode() {

        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        _1RemoveLinkElementLeetcode203 test = new _1RemoveLinkElementLeetcode203();
        ListNode node = new ListNode();
        ListNode head = node;
        for (int i = 0; i < 5; i++) {
            node.val = i;
            node.next = new ListNode();
            node = node.next;
        }
        ListNode testNode = head;
        while (testNode.next != null) {
            System.out.println(testNode.val);
            testNode = testNode.next;
        }
        ListNode listNode = test._01removeElements(head, 2);
        while (listNode.next != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode _01removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }

        ListNode pre = head;
        ListNode cur = head.next;

        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public ListNode _02removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(-1,head);
        ListNode pre = newHead;
        ListNode cur = pre.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next ;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return newHead.next;
    }


}
