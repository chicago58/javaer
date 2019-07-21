package com.wolf.javacommon.util;

/**
 * @Description
 * @Author wangqikang
 * @Date 2019-07-18 07:51
 */
public class SwapUtil {

    /**
     * 数组元素交换顺序
     *
     * @param arr 数组
     * @param m   数组下标
     * @param n   数组下标
     */
    public static void swapArray(int[] arr, int m, int n) {
        int temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
    }
}
