package com.wolf.javacommon.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author: liu lei
 * @Date: 2019/7/21
 */
@Setter
@Getter
@NoArgsConstructor
public class BTreeNode {
    private int data;
    private BTreeNode left;
    private BTreeNode right;

    public BTreeNode(int data) {
        this.data = data;
    }
}
