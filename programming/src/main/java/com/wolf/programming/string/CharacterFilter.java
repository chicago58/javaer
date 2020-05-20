package com.wolf.programming.string;

import java.util.Scanner;

/**
 * @Description
 * 题目描述：输入一个由字母、数字、空格组成的字符串和一个字符，输出该字符串中含有该字符的个数（不区分大小写）。
 * 输入描述：输入一个由字母、数字、空格组成的字符串和一个字符。
 * 输出描述：输出该字符串中含有该字符的个数。
 * @Author wangqikang
 * @Date 2019-08-13 08:17
 */
public class CharacterFilter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String ch = sc.nextLine();

            // 将字符串转换为字符数组
            char[] charArray = str.toCharArray();

            // 定义计数器
            int count = 0;

            // 遍历字符数组并计数
            for (int i = 0; i < charArray.length; i++) {
                if (ch.equalsIgnoreCase(String.valueOf(charArray[i]))) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}