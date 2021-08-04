package com.jjq.ap.binarytree.bst;

import com.jjq.ap.binarytree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/8/4
 * @desc 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 */
public class SmallKNode {


    public static void main(String[] args) {
        Integer value = smallKNode(buildTree(), 2).getValue();
        System.out.println("result value:" + value);
    }


    static BinaryTreeNode<Integer> smallKNode(BinaryTreeNode<Integer> root, int k) {
        List<BinaryTreeNode<Integer>> arr=new ArrayList<>();
        search(root, k, arr);
        return arr.get(k-1);
    }

    static void search(BinaryTreeNode<Integer> node, int k,
                                          List<BinaryTreeNode<Integer>> arr) {
        if (node == null) {
            return;
        }
        if (node.getLeft() != null) {
            search(node.getLeft(), k, arr);
        }
        arr.add(node);
        if (node.getRight() != null) {
            search(node.getRight(), k,arr);
        }
    }

    /**
     *             8
     *          /    \
     *        6       12
     *      /   \     / \
     *    2     7   10   14
     *
     */
    public static  BinaryTreeNode<Integer> buildTree() {

        BinaryTreeNode num8 = new BinaryTreeNode(8, null, null);
        BinaryTreeNode num6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode num12 = new BinaryTreeNode(12, null, null);
        BinaryTreeNode num2 = new BinaryTreeNode(2, null, null);
        BinaryTreeNode num7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode num10 = new BinaryTreeNode(10, null, null);
        BinaryTreeNode num14 = new BinaryTreeNode(14, null, null);

        num8.setLeft(num6);
        num8.setRight(num12);

        num6.setLeft(num2);
        num6.setRight(num7);

        num12.setLeft(num10);
        num12.setRight(num14);
        return num8;
    }


}
