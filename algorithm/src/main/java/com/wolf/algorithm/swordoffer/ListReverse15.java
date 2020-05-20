package com.wolf.algorithm.swordoffer;

import com.wolf.javacommon.bean.ListNode;

/**
 * @Author: liu lei
 * @Date: 2019/7/24
 * 带头的链表，头部放链表结点（除了头结点）的个数
 */
public class ListReverse15 {

    public static void main(String[] args) {
        ListNode head = buildList();
        printList(head);
        System.out.println();
        printList(reverse(head));

    }

    private static ListNode reverse(ListNode head){
        if(head == null || head.getNext() == null){
            return head;
        }
//        ListNode p = head.getNext();
//        ListNode q = p.getNext();
//        while (q.getNext() != null){
//            ListNode r = q.getNext();
//            q.setNext(p);
//            p = q;
//            q = r;
//        }
//        //head.setNext(p);
//        return p;
        //前一个节点指针
        ListNode preNode = null;
        //当前节点指针
        ListNode curNode = head;
        //下一个节点指针
        ListNode nextNode = null;

        while (curNode != null){
            nextNode = curNode.getNext();//nextNode 指向下一个节点
            if(nextNode != null) {
                System.out.print("nextNode:" + nextNode.getData());
            }
            curNode.setNext(preNode);//将当前节点next域指向前一个节点
            preNode = curNode;//preNode 指针向后移动
            System.out.print("-preNode:" + preNode.getData());
            curNode = nextNode;//curNode指针向后移动
            if(curNode != null) {
                System.out.print("-curNode:" + curNode.getData());
            }
            System.out.println();
        }
        //head.setNext(preNode);
        preNode.setData(head.getData());
        return preNode;
    }

    private static void printList(ListNode head){
        ListNode node = head.getNext();
        System.out.println("size:"+ head.getData());
        while (node.getNext() != null){
            System.out.print(node.getData()+" -> ");
            node = node.getNext();
        }
    }

    private static ListNode buildList(){
        ListNode head = new ListNode(0, new ListNode());

        ListNode n1 = new ListNode(2,new ListNode());
        head.setNext(n1);
        head.setData(head.getData() + 1);

        ListNode n2 = new ListNode(8,new ListNode());
        n1.setNext(n2);
        head.setData(head.getData() + 1);

        ListNode n3 = new ListNode(6,new ListNode());
        n2.setNext(n3);
        head.setData(head.getData() + 1);

        ListNode n4 = new ListNode(3,new ListNode());
        n3.setNext(n4);
        head.setData(head.getData() + 1);

        return head;
    }
}
