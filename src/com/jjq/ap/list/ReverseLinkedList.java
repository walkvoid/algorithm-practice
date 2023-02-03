package com.jjq.ap.list;

/**
 * @author jiangjunqing
 * @version 1.0.0
 * @date 2023/1/29
 * @desc https://leetcode.cn/problems/reverse-linked-list/
 */
public class ReverseLinkedList {

    /**
     *
     * @param head
     * @return 5->4->3->2->1   1->2->3->4->5
     * 5->4->3->2->1  => null<-5<-4<-3<-2<-1
     *
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 自己琢磨的
     * @param head
     * @return
     * 5->4->3->2->1
     * 4->3->2->1 5
     * 3->2->1 4->5
     * ......
     */
    public static ListNode reverseList2(ListNode head) {
        ListNode waitReHead = head;
        ListNode tempHead = null;
        while (waitReHead != null) {
            ListNode temp = waitReHead;
            waitReHead = waitReHead.next;
            temp.next = null;
            if (tempHead != null) {
                temp.next = tempHead;
            }
            tempHead = temp;
        }
        return tempHead;
    }

    /**
     * 递归方法
     */
    public static ListNode reverseList3(ListNode head) {
        return reverse(null, head);
    }

    /**
     * 递归方法
     *
     * 1<-2<-3<-4<-5
     *        pre<-cur  pre->cur
     */
    public static ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null) {
            return pre;
        }
        ListNode next = cur.next;
        cur.next = pre;
        return reverse(cur, next);
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(3, node2);
        ListNode node4 = new ListNode(4, node3);
        ListNode node5 = new ListNode(5, node4);
        ListNode listNode = reverseList3(node5);
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
