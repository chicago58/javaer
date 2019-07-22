package com.wolf.datastructure.tree;


import com.wolf.javacommon.bean.BTreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: liu lei
 * @Date: 2019/7/21
 */
public class PrintBTree {

    /**
     * 递归前序遍历
     *
     * @param node
     */
    private static void preOrder(BTreeNode node) {
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
    private static void midOrder(BTreeNode node) {
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
    private static void postOrder(BTreeNode node) {
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
    private static void fPreOrder(BTreeNode node) {
        Stack<BTreeNode> s = new Stack();
        s.push(node);
        while (!s.empty()) {
            BTreeNode n = s.pop();
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
    private static void fMidOrder(BTreeNode node) {
        Stack<BTreeNode> s = new Stack();
        BTreeNode cur = node;
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
    private static void fPostOrder(BTreeNode node) {
        Stack<BTreeNode> s1 = new Stack();
        Stack<BTreeNode> s2 = new Stack();
        s1.push(node);
        while (!s1.empty()) {
            BTreeNode n = s1.pop();
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

    private static void levelOrder(BTreeNode node) throws InterruptedException {
        Queue<BTreeNode> q = new ArrayDeque();
        q.add(node);
        while (!q.isEmpty()) {
            BTreeNode n = q.poll();
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
    private static BTreeNode buildTree() {
        BTreeNode node = new BTreeNode();
        BTreeNode left1 = new BTreeNode();
        BTreeNode right1 = new BTreeNode();
        node.setData(1);
        node.setLeft(left1);
        node.setRight(right1);
        right1.setData(3);
        BTreeNode right2 = new BTreeNode();
        left1.setData(2);
        left1.setRight(right2);
        BTreeNode left3 = new BTreeNode();
        BTreeNode right3 = new BTreeNode();
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
