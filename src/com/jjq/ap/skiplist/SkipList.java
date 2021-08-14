package com.jjq.ap.skiplist;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Random;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/7/9
 * @desc 跳跃列表实现
 *
 * https://www.jianshu.com/p/60d2561b821c 双向链表形式
 *
 * https://opendsa-server.cs.vt.edu/ODSA/Books/CS3/html/SkipList.html
 */

public class SkipList<V extends Comparable<V>> {


    private int level;

    private int size;

    private Node<V> HEAD = new Node();

    private Node<V> TAIL = new Node();

    // Hold the Random class object
    static private Random ran = new Random();

    public SkipList() {
        HEAD.right = TAIL;
        TAIL.left = HEAD;
    }


    public void add(V value) {
        Node<V> left = findLeft(value,0);
        if (left.value !=null && left.value.compareTo(value) == 0) {
            return;
        }

        Node<V> node = new Node<>(value);
        hInsert(left, node);

        //rise level
        int ranLevel = getRanLevel();
        Node<V> p = node;
        for (int i = 1; i <=ranLevel; i++) {
            Node<V> curNode = new Node<>(value);
            if (i>this.level) {
                adjustHeadAndTail();
                hInsert(HEAD, curNode);
                vInsert(p, curNode);
                level ++;
            } else {
                Node<V> leftI = findLeft(value, i);
                hInsert(leftI, curNode);
                vInsert(p, curNode);
            }
            p = curNode;
        }
    }

    private void adjustHeadAndTail(){
        Node<V> newHead = new Node<>();
        Node<V> newTail = new Node<>();
        Node<V> oldHead = HEAD;
        Node<V> oldTail = TAIL;
        oldHead.up = newHead;
        newHead.down = oldHead;
        oldTail.up = newTail;
        newTail.down = oldTail;
        newHead.right = newTail;
        newTail.left = newHead;
        HEAD = newHead;
        TAIL = newTail;
    }

    /**
     * 获取随机层数
     * @return
     */
    private int getRanLevel() {
        int level = 0;
        while (Math.abs(ran.nextInt())%2 == 0) {
            level++;
        }
        return level;
    }

    /**
     * horizontal insert(水平方向的插入)
     * @param left
     * @param node
     */
    private void hInsert(Node<V> left, Node<V> node) {
        Node<V> right = left.right;
        left.right = node;
        node.left = left;
        node.right = right;
        right.left = node;
    }

    /**
     * vertical insert(垂直方向的插入)
     * @param down
     * @param node
     */
    private void vInsert(Node<V> down, Node<V> node) {
        node.down =down;
        down.up = node;
    }



    public V get(V value) {
        Node<V> leftValue = findLeft(value, 0);
        if (leftValue.value !=null && leftValue.value.compareTo(value) == 0) {
            return leftValue.value;
        }
        return null;
    }

    @SuppressWarnings("unckecked")
    public Node<V> findLeft(V value, int level) {
        if (value == null || level> this.level) {
            throw new IllegalArgumentException();
        }
        Node<V> node = HEAD;
        while (true) {
            while (node.right.value !=null && node.right.value.compareTo(value) <= 0) {
                node = node.right;
            }
            if (this.level < ++level) {
                break;
            }
            node=node.down;
        }
        return node;
    }


    static class Node<V extends Comparable<V>> {
        V value;
        Node<V> left, right, up, down;

        public Node(V value) {
            this.value = value;
        }
        public Node() {
        }

        public int compareTo(Node<V> other) {
            if (this.value == null) {
                return -1;
            }
            if (other.value ==null) {
                return -1;
            }
            return this.value.compareTo(other.value);
        }



        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            sb.append("Node");

            //sb.append("@").append(this.hashCode());
            sb.append("{value=").append(value==null? "null" : value.toString());

            sb.append(",left=");
            //sb.append(left==null? "null" : left.hashCode()).append("@");
            sb.append(left != null && left.value != null? left.value : "null");

            sb.append(",right=");
            // .append(right==null? "null" : right.hashCode()).append("@");
            sb.append(right!=null && right.value!=null?  right.value : "null");

            sb.append(",up=");
            // .append(up==null? "null" : up.hashCode()).append("@");
            sb.append(up != null && up.value != null? up.value : "null");

            sb.append(",down=");
            // .append(down==null? "null" : down.hashCode()).append("@");
            sb.append(down != null && down.value != null? down.value : "null").append("}");
            return  sb.toString();
        }

    }

    public static void main(String[] args) {
        int size = 50;
        int bound = 50;
        Random random = new Random();
        SkipList<Integer> skipList = new SkipList<>();
        for (int i = 0; i < size; i++) {
            skipList.add(random.nextInt(bound));
        }
        int level = skipList.level;
        Node<Integer> p = skipList.HEAD;
        Node<Integer> head = skipList.HEAD;
        StringBuilder sb = new StringBuilder();
        while (level >= 0){
            sb.append("\n第").append(level).append("层:");
            while (p != null) {
                sb.append(p.value).append("--");
                p = p.right;
            }

            if (head == null) {
                break;
            }
            level--;
            head = head.down;
            p = head;
        }
        System.out.println(sb.toString());
    }


}
