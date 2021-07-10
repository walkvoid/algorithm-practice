package com.jjq.ap.skiplist;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/7/9
 * @desc 跳跃列表实现
 */
public class SkipList<V extends Comparable> {

    int level;

    //层数最大值
    final static int MAX_LEVEL = 32;

    //生层的概率
    final static double PROBABILITY	= 0.25d;

    final static Node HEAD = new Node();

    final static Node TAIL = new Node();

    public SkipList() {
        HEAD.right = TAIL;
        TAIL.left = HEAD;
    }

    public void add(V value) {
        if (value == null) {
            throw new IllegalArgumentException("value is null");
        }
        //查找节点,如果已存在,直接返回

    }

    public boolean delete(V value) {
        if (value == null) {
            throw new IllegalArgumentException("value is null");
        }

        return false;

    }

    public Node find(V value) {
        if (value == null) {
            throw new IllegalArgumentException("value is null");
        }
        Node p = HEAD;
        while (true) {
            while (p.right != null && value.compareTo(p.right) > 0) {
                p = p.right;
            }
            if (p.down == null) {
                break;
            }
            p = p.down;
        }
       return p;
    }






    /**
     * node
     * @param <V>
     */

    static class Node<V extends Comparable>{

        V value;

        //指向周围的四个元素
        public Node<V> up ,down, left, right;

        public Node(V value) {
            this.value = value;
        }

        public Node() {
        }
    }


}
