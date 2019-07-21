package com.wolf.algorithm;


import com.wolf.javacommon.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: liu lei
 * @Date: 2019/7/21
 */
public class PrintTree {

    /**
     * 递归前序遍历
     *
     * @param node
     */
    private static void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getData() + " ");
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    /**
     * 递归中序遍历
     *
     * @param node
     */
    private static void midOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        midOrder(node.getLeft());
        System.out.print(node.getData() + " ");
        midOrder(node.getRight());
    }

    /**
     * 递归后序遍历
     *
     * @param node
     */
    private static void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.print(node.getData() + " ");
    }

    /**
     * 非递归前序遍历
     *
     * @return
     */
    private static void fPreOrder(TreeNode node) {
        Stack<TreeNode> s = new Stack();
        s.push(node);
        while (!s.empty()) {
            TreeNode n = s.pop();
            System.out.print(n.getData() + " ");
            if (n.getRight() != null) {
                s.push(n.getRight());
            }
            if (n.getLeft() != null) {
                s.push(n.getLeft());
            }
        }
    }


    /**
     * 非递归中序遍历
     *
     * @return
     */
    private static void fMidOrder(TreeNode node) {
        Stack<TreeNode> s = new Stack();
        TreeNode cur = node;
        while (!s.empty() || cur != null) {
            while (cur != null) {
                s.push(cur);
                cur = cur.getLeft();
            }
            cur = s.pop();
            System.out.print(cur.getData() + " ");
            cur = cur.getRight();
        }
    }

    /**
     * 非递归后序遍历
     *
     * @return
     */
    private static void fPostOrder(TreeNode node) {
        Stack<TreeNode> s1 = new Stack();
        Stack<TreeNode> s2 = new Stack();
        s1.push(node);
        while (!s1.empty()) {
            TreeNode n = s1.pop();
            if (n.getLeft() != null) {
                s1.push(n.getLeft());
            }
            if (n.getRight() != null) {
                s1.push(n.getRight());
            }
            s2.push(n);
        }
        while (!s2.empty()) {
            System.out.print(s2.pop().getData() + " ");
        }
    }

    private static void levelOrder(TreeNode node) throws InterruptedException {
        Queue<TreeNode> q = new ArrayDeque();
        q.add(node);
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            System.out.print(n.getData() + " ");
            if (n.getLeft() != null) {
                q.add(n.getLeft());
            }
            if (n.getRight() != null) {
                q.add(n.getRight());
            }
        }
    }

    /**
     * 创建二叉树
     *    1
     *  /   \
     *  2   3
     *  \
     *  4
     * / \
     *5  6
     */
    private static TreeNode buildTree() {
        TreeNode node = new TreeNode();
        TreeNode left1 = new TreeNode();
        TreeNode right1 = new TreeNode();
        node.setData(1);
        node.setLeft(left1);
        node.setRight(right1);
        right1.setData(3);
        TreeNode right2 = new TreeNode();
        left1.setData(2);
        left1.setRight(right2);
        TreeNode left3 = new TreeNode();
        TreeNode right3 = new TreeNode();
        right2.setData(4);
        right2.setLeft(left3);
        right2.setRight(right3);
        left3.setData(5);
        right3.setData(6);
        return node;
    }


    public static void main(String[] args) {
//        preOrder(buildTree());
//        System.out.println();
//        midOrder(buildTree());
        System.out.println();
        postOrder(buildTree());
        System.out.println();

//        fPreOrder(buildTree());
//        fMidOrder(buildTree());
//        fMidOrderV2(buildTree());
//        fPostOrder(buildTree());
        System.out.println();
        try {
            levelOrder(buildTree());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
