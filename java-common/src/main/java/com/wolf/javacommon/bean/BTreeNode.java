package com.wolf.javacommon.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: liu lei
 * @Date: 2019/7/21
 */
@Setter
@Getter
public class BTreeNode {
    private int data;
    private BTreeNode left;
    private BTreeNode right;
}
