package com.wolf.algorithm.swordoffer;

import com.wolf.javacommon.bean.BTreeNode;

import java.util.Arrays;

/**
 * @Description 输入二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * @Author wangqikang
 * @Date 2019-07-28 17:45
 */
public class ReConstructBinaryTree {

    /**
     * @param preOrder 前序遍历
     * @param midOrder 中序遍历
     * @return 二叉树
     */
    private static BTreeNode reconstructBinaryTree(int[] preOrder, int[] midOrder) {
        if (preOrder.length == 0 || midOrder.length == 0) {
            return null;
        }

        BTreeNode treeNode = new BTreeNode(preOrder[0]);
        for (int i = 0; i < midOrder.length; i++) {
            if (preOrder[0] == midOrder[i]) {
                treeNode.setLeft(reconstructBinaryTree(Arrays.copyOfRange(preOrder, 1, i + 1),
                        Arrays.copyOfRange(midOrder, 0, i)));
                treeNode.setRight(reconstructBinaryTree(Arrays.copyOfRange(preOrder, i + 1, preOrder.length),
                        Arrays.copyOfRange(midOrder, i + 1, midOrder.length)));
            }
        }

        return treeNode;
    }

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] midOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        reconstructBinaryTree(preOrder, midOrder);
    }
}
