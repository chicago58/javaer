package com.wolf.javacommon.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: liu lei
 * @Date: 2019/7/23
 */
@Getter
@Setter
@AllArgsConstructor
public class ListNode {
    private int data;
    private ListNode next;
    public ListNode(){}

    public ListNode(int data){
        this.data = data;
    }
}
