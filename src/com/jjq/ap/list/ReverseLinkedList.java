package com.jjq.ap.list;

/**
 * @author jiangjunqing
 * @version 1.0.0
 * @date 2023/1/29
 * @desc https://leetcode.cn/problems/reverse-linked-list/
 */
public class ReverseLinkedList {

    /**
     * 递归方式反转列表
     * @param head
     * @return 5->4->3->2->1   1->2->3->4->5
     * 5->4->3->2->1  =>  3->2->1 4->5
     *
     */
    public ListNode reverseList(ListNode head) {
        if (head.next == null) {

        } else {
            ListNode tempNode = head.next.next;
            head.next = head;
        }

        return null;
    }

    /**
     *
     * @param head
     * @return
     * 5->4->3->2->1  =>  3->2->1 4->5
     */
    public static ListNode reverseList2(ListNode head) {
        ListNode waitReHead = head;
        ListNode tempHead = head;
        while (waitReHead != null && waitReHead.next != null) {
            tempHead = waitReHead.next;
            tempHead.next = waitReHead;
            waitReHead = waitReHead.next.next;
        }
        return tempHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(3, node2);
        ListNode node4 = new ListNode(4, node3);
        ListNode node5 = new ListNode(5, node4);
        ListNode listNode = reverseList2(node5);
        System.out.println(listNode);



    }

    /**
     * 单链表节点结构
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
