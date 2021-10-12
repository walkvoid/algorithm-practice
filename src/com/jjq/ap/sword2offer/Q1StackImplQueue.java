package com.jjq.ap.sword2offer;

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


    public static void main(String[] args) {
        Q1StackImplQueue q1StackImplQueue = new Q1StackImplQueue();
        q1StackImplQueue.appendTail(1);
        q1StackImplQueue.appendTail(2);
        q1StackImplQueue.appendTail(3);
        System.out.println(q1StackImplQueue.toString());
        q1StackImplQueue.deleteHead();
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
            Integer pop = s1.pop();

            int s1s = s1.size();
            for (int i = 0; i <s1s; i++) {
                s2.push(s1.pop());
            }
            return pop;
        }
        return -1;
    }


    @Override
    public String toString() {
        if (!s1.empty()) {
            return s1.toString();
        }
        if (!s2.empty()) {
            return s1.toString();
        }
        return "";
    }
}
