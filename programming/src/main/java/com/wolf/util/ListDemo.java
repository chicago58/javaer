package com.wolf.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description 遍历List集合删除元素的正确方式
 * @Author wangqikang
 * @CreatedAt 2020-03-10 13:57
 **/
public class ListDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String data = iterator.next();
            if (data.equals("3")) {
                System.out.println(data);
                iterator.remove();
            }
        }

//        for (String item : list) {
//            if (item.equals("3")) {
//                System.out.println(item);
//                list.remove(item);
//            }
//        }

        System.out.println(list.size());
    }
}
