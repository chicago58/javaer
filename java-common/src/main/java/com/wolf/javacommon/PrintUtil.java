package com.wolf.javacommon;

/**
 * @Description
 * @Author wangqikang
 * @Date 2019-07-17 23:11
 */
public class PrintUtil {

    /**
     * 打印数组
     *
     * @param arr 待打印数组
     */
    public static void printArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }

        System.out.println("\r\n");
    }
}
