package com.wolf.datastructure.tree;

import com.alibaba.fastjson.JSON;
import com.wolf.javacommon.bean.MTreeNode;
import com.wolf.javacommon.bean.TraceNodeVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: liu lei
 * @Date: 2019/7/22
 * 根据根结点到叶结点的路径还原（构造，重建）多叉树
 *                  0
 *                 / \
 *                11  12
 *               / \   |
 *              21 22  21
 *              |  |   |
 *              31 33  32
 *              |  |   |
 *              41 43  42
 */
public class ConstructMultiTree {
    static Map<Long,MTreeNode> map = new HashMap<>();
    public static void main(String[] args) {

        MTreeNode root  = new MTreeNode( 0L, 0, "", new ArrayList<>());

        TraceNodeVO tn1 = new TraceNodeVO(11L,21L,31L,41L);
        TraceNodeVO tn2 = new TraceNodeVO(12L,21L,32L,42L);
        TraceNodeVO tn3 = new TraceNodeVO(11L,22L,33L,43L);

        MTreeNode mtn01 = new MTreeNode(11L, 1, "11L", null);
        MTreeNode mtn02 = new MTreeNode(12L, 1, "12L", null);
        MTreeNode mtn03 = new MTreeNode(21L, 2, "21L", null);
        MTreeNode mtn04 = new MTreeNode(22L, 2, "22L", null);
        MTreeNode mtn05 = new MTreeNode(31L, 3, "31L", null);
        MTreeNode mtn06 = new MTreeNode(32L, 3, "32L", null);
        MTreeNode mtn07 = new MTreeNode(33L, 3, "33L", null);
        MTreeNode mtn08 = new MTreeNode(41L, 4, "41L", null);
        MTreeNode mtn09 = new MTreeNode(42L, 4, "42L", null);
        MTreeNode mtn10 = new MTreeNode(43L, 4, "43L", null);

        //1将所有路径加载到list中
        List<TraceNodeVO> traceList = new ArrayList<TraceNodeVO>();
        traceList.add(tn1);
        traceList.add(tn2);
        traceList.add(tn3);
        //2将所有基础数据加载到map中
        map.put(mtn01.getId(), mtn01);
        map.put(mtn02.getId(), mtn02);
        map.put(mtn03.getId(), mtn03);
        map.put(mtn04.getId(), mtn04);
        map.put(mtn05.getId(), mtn05);
        map.put(mtn06.getId(), mtn06);
        map.put(mtn07.getId(), mtn07);
        map.put(mtn08.getId(), mtn08);
        map.put(mtn09.getId(), mtn09);
        map.put(mtn10.getId(), mtn10);

        for (TraceNodeVO trace : traceList) {
            MTreeNode parent = root;
            parent = insertNode(initNode(trace.getFirstId()), parent.getSonList());
//            System.out.println("1:"+JSON.toJSONString(parent));
            if(null == parent.getSonList()){
                parent.setSonList(new ArrayList<>());
            }
            parent = insertNode(initNode(trace.getSecondId()), parent.getSonList());
//            System.out.println("2:"+JSON.toJSONString(parent));
            if(null == parent.getSonList()){
                parent.setSonList(new ArrayList<>());
            }
            parent = insertNode(initNode(trace.getThirdId()), parent.getSonList());
//            System.out.println("3:"+JSON.toJSONString(parent));
            if(null == parent.getSonList()){
                parent.setSonList(new ArrayList<>());
            }
            insertNode(initNode(trace.getForthId()), parent.getSonList());

        }
        List<MTreeNode> sonList = root.getSonList();
        System.out.println(JSON.toJSONString(sonList));

    }

    /**
     * 初始化结点信息，新建结点，不然会出现结点错乱
     * @param id
     * @return
     */
    private static MTreeNode initNode(long id){
        MTreeNode n = new MTreeNode();
        MTreeNode vo = map.get(id);
        if(null == vo){
            //抛异常
            return n;
        }
        n.setId(vo.getId());
        n.setLevel(vo.getLevel());
        n.setName(vo.getName());
        return n;
    }
    /**
     * 如果树中无此结点，向树中插入一个结点
     * @param node
     * @param sonList
     * @return
     */
    private static MTreeNode insertNode(MTreeNode node, List<MTreeNode> sonList){
        boolean flag = false;
        for (MTreeNode n : sonList) {
            if(n.getId().equals(node.getId())){
                flag = true;
                node = n;
                break;
            }
        }
        //树中不存在则添加
        if(!flag){
            sonList.add(node);
        }
        return node;
    }
}
