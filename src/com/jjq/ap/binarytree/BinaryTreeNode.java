package com.jjq.ap.binarytree;


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
    public String toString() {
        return value.toString();
    }

}
