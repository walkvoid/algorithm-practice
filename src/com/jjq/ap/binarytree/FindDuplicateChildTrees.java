package com.jjq.ap.binarytree;

import java.util.List;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/5/30
 * @desc 找到重复的子树
 * @link https://labuladong.gitee.io/algo/2/18/22/
 */
public class FindDuplicateChildTrees {

    public static void main(String[] args) {

    }

    public static List<BinaryTreeNode<Integer>> findDuplicateChildTrees(List<BinaryTreeNode<Integer>> list,
                                                                        List<BinaryTreeNode<Integer>> result,
                                                                        BinaryTreeNode<Integer> root) {
        if (root.getLeft() !=null) {
            findDuplicateChildTrees(list,result,root.getLeft());
        }

        if (root.getRight() !=null) {
            findDuplicateChildTrees(list,result, root.getRight());
        }

        if (list.contains(root)) {

        }
        list.add(root);
        return list;
    }
}
