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
     * 递归实现前序遍历
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
     * 递归实现中序遍历
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
     * 递归实现后序遍历
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
     * 非递归实现前序遍历
     *
     * @return
     */
    private static void fPreOrder(BTreeNode node) {
        // 创建存放结点
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
     * 非递归实现中序遍历
     *
     * @return
     */
    private static void fMidOrder(BTreeNode node) {
        // 创建存放结点
        Stack<BTreeNode> s = new Stack();
        // 创建变量指针cur表示当前正在访问的结点
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
     * 非递归实现后序遍历
     *
     * @return
     */
    private static void fPostOrder(BTreeNode node) {
        // 创建2个栈用于存放结点
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

    /**
     * 层序遍历
     *
     * @param node
     * @throws InterruptedException
     */
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
     * <p>
     *     1
     *   /   \
     *  2    3
     *   \
     *   4
     *  / \
     * 5  6
     */
    private static BTreeNode buildTree() {
        BTreeNode node = new BTreeNode();
        node.setData(1);
        BTreeNode left1 = new BTreeNode();
        left1.setData(2);
        BTreeNode right1 = new BTreeNode();
        right1.setData(3);

        node.setLeft(left1);
        node.setRight(right1);

        BTreeNode right2 = new BTreeNode();
        right2.setData(4);
        left1.setRight(right2);

        BTreeNode left3 = new BTreeNode();
        left3.setData(5);
        BTreeNode right3 = new BTreeNode();
        right3.setData(6);

        right2.setLeft(left3);
        right2.setRight(right3);
        return node;
    }


    public static void main(String[] args) {
        // 创建二叉树
        BTreeNode treeNode = buildTree();

        // 前序遍历二叉树（递归实现）
        System.out.print("\n前序遍历（递归实现）：");
        preOrder(treeNode);

        // 中序遍历二叉树（递归实现）
        System.out.print("\n中序遍历（递归实现）：");
        midOrder(treeNode);

        // 后序遍历二叉树（递归实现）
        System.out.print("\n后序遍历（递归实现）：");
        postOrder(treeNode);

        // 前序遍历二叉树（非递归实现）
        System.out.print("\n前序遍历（非递归实现）：");
        fPreOrder(treeNode);

        // 中序遍历二叉树（非递归实现）
        System.out.print("\n中序遍历（非递归实现）：");
        fMidOrder(treeNode);

        // 后序遍历二叉树（非递归实现）
        System.out.print("\n后序遍历（非递归实现）：");
        fPostOrder(treeNode);

        // 层序遍历
        try {
            System.out.print("\n层序遍历：");
            levelOrder(treeNode);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
