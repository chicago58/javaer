package com.wolf.programming.string;

import java.util.Scanner;

/**
 * @Description
 * 题目描述：计算字符串最后一个单词的长度，单词以空格隔开。
 * 输入描述：一行字符串，非空，长度小于5000。
 * 输出描述：整数N，最后一个单词的长度。
 * @Author wangqikang
 * @Date 2019-08-13 08:08
 */
public class LastWordLength {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            int length = calculateLengthOfLast(str);
            System.out.println(length);
        }
    }

    private static int calculateLengthOfLast(String str) {
        String[] words = str.split(" ");
        return words[words.length - 1].length();
    }
}
