package com.jjq.ap.binarytree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/5/30
 * @desc 序列化和反序列化树
 */
public class SerAndDesTree implements Serializable {

    public final static String SPIT = "#";

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = buildTree();
        ArrayList<String> result = new ArrayList<String>(16);
        List<String> serialize = serialize(root, result);
        System.out.println(serialize);
        BinaryTreeNode<Integer> deserialize = deserialize(result, 0);
        System.out.println(deserialize);

    }

    /**
     * 使用前序
     * @param root
     * @return
     */
    private static List<String> serialize(BinaryTreeNode<Integer> root, List<String> result) {
        if (root == null) {
            result.add("#");
            return result;
        } else {
            result.add(String.valueOf(root.getValue()));
        }
        serialize(root.getLeft(), result);
        serialize(root.getRight(), result);
        return result;
    }

    private static BinaryTreeNode<Integer>  deserialize(List<String> arr, int index) {
        if (arr.get(0).equals(SPIT)) {
            return null;
        }
        String s = arr.get(index);
        BinaryTreeNode<Integer> root = null;
        if (!s.equals(SPIT)) {
            root = new BinaryTreeNode<Integer>(Integer.parseInt(s), null, null);
        } else {
            return root;
        }
        root.setLeft(deserialize(arr, index+1));
        root.setRight(deserialize(arr, index+1));
        return root;
    }


    /**
     *             1
     *           /   \
     *          2     5          ==>    1--2--3--#-#--4--#--#--5-#-6-#-#
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

}
