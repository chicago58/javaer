package com.wolf.javacommon.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author: liu lei
 * @Date: 2019/7/22
 */
@Getter
@Setter
@AllArgsConstructor
public class MTreeNode {
    private Long id;            //结点id
    private Integer level;      // 层
    private String name;        //结点名称
    private List<MTreeNode> sonList; //该结点的 子结点集合
    public MTreeNode(){}
}
