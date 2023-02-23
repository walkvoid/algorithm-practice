package com.jjq.ap.queue;

import java.util.Stack;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/10/12
 * @desc https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * 用两个栈实现队列
 */
public class Q1StackImplQueue {


    public static Stack<Integer> s1 = new Stack<Integer>();


    public static Stack<Integer> s2 = new Stack<Integer>();


    //["CQueue","appendTail","deleteHead","appendTail","appendTail","deleteHead","deleteHead","appendTail","appendTail","appendTail","deleteHead","deleteHead","deleteHead","appendTail","appendTail","deleteHead","deleteHead","deleteHead","appendTail","appendTail","deleteHead"]
    //[[],[11],[],[1],[17],[],[],[19],[20],[13],[],[],[],[12],[3],[],[],[],[10],[19],[]]
    public static void main(String[] args) {

        Q1StackImplQueue q1StackImplQueue = new Q1StackImplQueue();
        q1StackImplQueue.appendTail(11);
        System.out.println(q1StackImplQueue.toString());
        q1StackImplQueue.deleteHead();
        System.out.println(q1StackImplQueue.toString());
        q1StackImplQueue.appendTail(1);
        q1StackImplQueue.appendTail(17);
        System.out.println(q1StackImplQueue.toString());
        q1StackImplQueue.deleteHead();
        q1StackImplQueue.deleteHead();
        System.out.println(q1StackImplQueue.toString());
        q1StackImplQueue.appendTail(19);
        q1StackImplQueue.appendTail(20);
        q1StackImplQueue.appendTail(13);
        System.out.println(q1StackImplQueue.toString());
    }



    public void appendTail(int value) {
        if (!s1.empty()) {
            s1.push(value);
            return;
        }

        if (!s2.empty()) {
            s2.push(value);
            return;
        }

        s1.push(value);
    }

    public int deleteHead() {
        if (!s1.empty()) {
            int s1s = s1.size();
            for (int i = 0; i <s1s; i++) {
                s2.push(s1.pop());
            }
            Integer result = s2.pop();

            int s2s = s2.size();
            for (int i = 0; i <s2s; i++) {
                s1.push(s2.pop());
            }
            return result;
        }
        if (!s2.empty()) {
            int s2s = s2.size();
            for (int i = 0; i <s2s; i++) {
                s1.push(s2.pop());
            }
            Integer res = s1.pop();

            int s1s = s1.size();
            for (int i = 0; i <s1s; i++) {
                s2.push(s1.pop());
            }
            return res;
        }
        return -1;
    }


    @Override
    public String toString() {
        if (!s1.empty()) {
            return s1.toString();
        }
        if (!s2.empty()) {
            return s2.toString();
        }
        return "";
    }
}
