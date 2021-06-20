package com.jjq.ap.binarytree;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/4/13
 * @desc 遍历树
 */
public class TraverseTree {

    public static void main(String[] args) {
        BinaryTreeNode<Person> root = buildSanguoTree();
        traverse(root);
    }


    /**
     * 前/中/后序遍历树,取决于root被遍历的顺序
     * @param root
     */
    public static void traverse(BinaryTreeNode<Person> root) {
        System.out.println(root.getValue().getName());

        if (root.getLeft() !=null) {
            traverse(root.getLeft());
        }

        if (root.getRight() !=null) {
            traverse(root.getRight());
        }


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
    public static  BinaryTreeNode<Person> buildSanguoTree() {
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
