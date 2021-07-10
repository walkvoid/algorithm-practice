package com.jjq.ap.lru;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/7/10
 * @desc 1
 */
public class LRUCache {

    int capacity;

    //tail-->head
    Node HEAD = new Node();

    Node TAIL = new Node();

    Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        if (capacity<1) {
            throw new IllegalArgumentException("capacity must gt 0");
        }
        this.capacity = capacity;
        TAIL.next = HEAD;
        HEAD.prev = TAIL;
    }

    /**
     * 根据key从map获取value,并且将key在list中的位置移动到尾部(tail)
     * @param key
     * @return 没找到返回-1
     */
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            moveToTail(node);
            return map.get(key).value;
        }
        return -1;

    }

    private void moveToTail(Node node) {
        if (TAIL.next != node) {
            Node temp = TAIL.next;
            TAIL.next = node;
            node.prev = TAIL;
            node.next = temp;
            temp.prev = node;
        }
    }

    private void removeNode(Node node) {
        if (TAIL.next != node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    /**
     *
     * @param key
     * @param value
     * @return
     */
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            //更新
            Node node = new Node(key, value);
            removeNode(map.get(key));
            map.put(key, node);
            moveToTail(node);
        } else {
            //新增,如果node的个数大于capacity,需要删除头节点的node
            if (map.size() >= capacity) {
                map.remove(HEAD.prev.key);
                removeNode(HEAD.prev);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            moveToTail(node);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 4);
        lruCache.put(3, 4);
        System.out.println(lruCache);

    }

    @Override
    public String toString() {
        return "LRUCache{" +
                "capacity=" + capacity +
                '}';
    }

    static class Node{
        int key, value;
        Node prev, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", prev=" + prev +
                    ", next=" + next +
                    '}';
        }
    }
}
