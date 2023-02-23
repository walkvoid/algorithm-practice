package com.jjq.ap.tree;


import com.jjq.ap.binarytree.Person;

/**
 * @author jiangjunqing
 * @version v1.0.0
 * @date 2023/2/23
 * @desc 计算二叉树的最大深度  https://leetcode.cn/problems/maximum-depth-of-binary-tree/ 104
 */
public class CalcTreeMaxDepth {

    public static void main(String[] args) {
        int i = calcTreeMaxDepth0(buildSanguoTree());
        System.out.println("result: " + i);
    }

    public static int calcTreeMaxDepth() {
        return 0;
    }

    public static int calcTreeMaxDepth0(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int rightDepth = calcTreeMaxDepth0(root.getRight());
        int leftDepth  = calcTreeMaxDepth0(root.getLeft());
        return 1 + Math.max(rightDepth, leftDepth);
    }


    /**
     *            刘备
     *          /      \
     *       关羽      张飞
     *      /   \      /
     *    关平 关银屏  张苞
     *         /
     *       关银儿
     *
     */
    public static BinaryTreeNode<Person> buildSanguoTree() {
        Person liubei = new Person("刘备", 100);
        Person guanyu = new Person("关羽", 98);
        Person zhangfei = new Person("张飞", 97);
        Person guanping = new Person("关平", 88);
        Person guanyinping = new Person("关银屏", 85);
        Person zhangbao = new Person("张苞", 87);
        Person guanyiner = new Person("关银儿", 65);
        BinaryTreeNode liubeiNode = new BinaryTreeNode(liubei, null, null);
        BinaryTreeNode guanyuNode = new BinaryTreeNode(guanyu, null, null);
        BinaryTreeNode zhangfeiNode = new BinaryTreeNode(zhangfei, null, null);
        BinaryTreeNode guanpingNode = new BinaryTreeNode(guanping, null, null);
        BinaryTreeNode guanyinpingNode = new BinaryTreeNode(guanyinping, null, null);
        BinaryTreeNode zhangbaoNode = new BinaryTreeNode(zhangbao, null, null);
        BinaryTreeNode guanyinerNode = new BinaryTreeNode(guanyiner, null, null);

        liubeiNode.setLeft(guanyuNode);
        liubeiNode.setRight(zhangfeiNode);

        guanyuNode.setLeft(guanpingNode);
        guanyuNode.setRight(guanyinpingNode);

        guanyinpingNode.setLeft(guanyinerNode);

        zhangfeiNode.setLeft(zhangbaoNode);
        return liubeiNode;
    }


}
