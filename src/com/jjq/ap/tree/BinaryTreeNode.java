package com.jjq.ap.tree;


import java.util.Objects;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/2/26
 * @desc 二叉树结点
 */
public class BinaryTreeNode<V> {

    private V value;

    private BinaryTreeNode<V> left;

    private BinaryTreeNode<V> right;

    public BinaryTreeNode<V> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<V> left) {
        this.left = left;
    }

    public BinaryTreeNode<V> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<V> right) {
        this.right = right;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public BinaryTreeNode(V value, BinaryTreeNode<V> left, BinaryTreeNode<V> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryTreeNode<?> that = (BinaryTreeNode<?>) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}
