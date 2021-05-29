package com.jjq.ap.binarytree;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/5/28
 * @desc 数转换为链表
 * @link https://labuladong.gitbook.io/algo/mu-lu-ye-1/mu-lu-ye-1/er-cha-shu-xi-lie-1
 */
public class Tree2List {


    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = buildTree();
        tree2List(root);
        traverse(root);
    }


    /**
     * 翻转二叉树
     */
    public static void tree2List(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        tree2List(root.getLeft());
        tree2List(root.getRight());

        BinaryTreeNode<Integer> right = root.getRight();
        root.setRight(root.getLeft());
        root.setLeft(null);

        BinaryTreeNode<Integer> p = root;
        while (p.getRight() != null) {
            p = p.getRight();
        }
        p.setRight(right);
    }

    /**
     *             1                           
     *           /   \                      
     *          2     5          ==>    1--2--3--4--5--6
     *        /  \     \               
     *       3    4     6
     */
    public static  BinaryTreeNode<Integer> buildTree() {

        BinaryTreeNode num1 = new BinaryTreeNode(1, null, null);
        BinaryTreeNode num2 = new BinaryTreeNode(2, null, null);
        BinaryTreeNode num5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode num3 = new BinaryTreeNode(3, null, null);
        BinaryTreeNode num4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode num6 = new BinaryTreeNode(6, null, null);

        num1.setLeft(num2);
        num1.setRight(num5);

        num2.setLeft(num3);
        num2.setRight(num4);

        num5.setRight(num6);
        return num1;
    }

    public static void traverse(BinaryTreeNode<Integer> root) {
        System.out.println(root.getValue());
        if (root.getLeft() !=null) {
            traverse(root.getLeft());
        }

        if (root.getRight() !=null) {
            traverse(root.getRight());
        }
    }

}