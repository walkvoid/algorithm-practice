package com.jjq.ap.binarytree;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/5/29
 * @desc 根据数组构造最大的二叉树
 * @link https://labuladong.gitee.io/algo/2/18/21/
 */
public class MaxBinaryTree {

    public static int[] SRC_ARRAY = {3,2,1,6,0,5};

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = buildMaxBinaryTree(SRC_ARRAY);
        System.out.println(root);
    }


    public static BinaryTreeNode<Integer>  buildMaxBinaryTree(int[] arr) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(0,null,null);
        int temp = 0;
        buildMaxBinaryTree(root, arr, 0, arr.length-1, temp);
        return root;
    }

    public static void  buildMaxBinaryTree( BinaryTreeNode<Integer> root, int[] arr, int start, int end , int temp) {
        if (start > end) {
            return;
        }
        int maxIndex = maxIndex(arr, start, end, temp);
        root.setValue(arr[maxIndex]);

        if (maxIndex>start) {
            BinaryTreeNode<Integer> left = new BinaryTreeNode<>(null, null, null);
            root.setLeft(left);
            buildMaxBinaryTree(left, arr, start, maxIndex-1, temp);
        }

        if (maxIndex<end) {
            BinaryTreeNode<Integer> right = new BinaryTreeNode<>(null, null, null);
            root.setRight(right);
            buildMaxBinaryTree(right, arr,maxIndex+1, end, temp);
        }

    }

    private static int maxIndex(int[] arr, int start, int end, int temp) {
        temp = arr[start];
        for (int i=start; i<=end; i++) {
            if (temp < arr[i]) {
                temp = arr[i];
                start=i;
            }
        }
        return start;
    }
}
