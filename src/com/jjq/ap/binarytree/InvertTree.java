package com.jjq.ap.binarytree;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/4/13
 * @desc 翻转二叉树
 */
public class InvertTree {


    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = buildTree();
        invertTree(root);
        //打印翻转后的结果
        traverse(root);
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

    /**
     * 翻转二叉树
     */
    public static  BinaryTreeNode<Integer> invertTree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return null;
        }
        BinaryTreeNode<Integer> tmp = root.getRight();
        root.setRight(root.getLeft());
        root.setLeft(tmp);

        invertTree(root.getLeft());
        invertTree(root.getRight());
        return root;
    }



    /**
     *             8                           8
     *          /    \                      /     \
     *        6       12          ==>     12       6
     *      /   \     / \               /   \    /  \
     *    2     7   10   14            14   10  7    2
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
