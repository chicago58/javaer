package com.wolf.datastructure.sort;

import com.wolf.javacommon.util.PrintUtil;
import com.wolf.javacommon.util.SwapUtil;

/**
 * @Description 冒泡排序
 * @Author wangqikang
 * @Date 2019-07-14 10:17
 */
public class BubbleSort {

    /**
     * 最基本的冒泡排序
     *
     * @param arr 待排序数组
     */
    public static void baseBubbleSort(int[] arr) {
        System.out.print("原数组：");
        PrintUtil.printArray(arr);

        /**
         * 第几趟：每一趟都会找出一个最值（最小值）
         */
        for (int i = 0; i < arr.length; i++) {

            /**
             * 每趟中逐个两两比较，目的是将较小值"上浮"
             */
            for (int j = arr.length - 1, count = 1; j > i; j--, count++) {

                if (arr[j - 1] > arr[j]) {
                    // 交换
                    SwapUtil.swapArray(arr, j - 1, j);
                }

                System.out.print("第" + (i + 1) + "趟排序第" + count + "次比较：\t");
                PrintUtil.printArray(arr);
            }
        }
    }

    /**
     * 优化：若某趟排序没有发生交换，则数组已完全有序。
     *
     * @param arr 待排序数组
     */
    public static void optBubbleSortWithSwap(int[] arr) {
        System.out.print("原数组：");
        PrintUtil.printArray(arr);

        // 发生交换则标记
        boolean doSwap;

        for (int i = 0; i < arr.length - 1; i++) {

            doSwap = false;
            for (int j = arr.length - 1, count = 1; j > i; j--, count++) {

                if (arr[j] < arr[j - 1]) {
                    SwapUtil.swapArray(arr, j - 1, j);
                    doSwap = true;
                }

                System.out.print("第" + (i + 1) + "趟排序第" + count + "次比较：\t");
                PrintUtil.printArray(arr);
            }

            // 若没有标记，则数组已经完全有序。
            if (!doSwap) {
                return;
            }
        }
    }

    /**
     * 优化：标记每趟排序的最终交换位置
     *
     * @param arr 待排序数组
     */
    public static void optBubbleSortWithSwapLocation(int[] arr) {
        System.out.print("原数组：");
        PrintUtil.printArray(arr);

        // 标记发生交换的位置
        int lastSwapIndex = 0, lastSwapIndexTemp = 0;

        for (int i = 0; i < arr.length - 1; i++) {

            lastSwapIndex = lastSwapIndexTemp;
            for (int j = arr.length - 1, count = 1; j > lastSwapIndex; j--, count++) {

                if (arr[j] < arr[j - 1]) {
                    SwapUtil.swapArray(arr, j - 1, j);
                    lastSwapIndexTemp = j;
                }

                System.out.print("第" + (i + 1) + "趟排序第" + count + "次比较：\t");
                PrintUtil.printArray(arr);
            }

            // 若一趟排序后标记的位置相等，则数组已经完全有序。
            if (lastSwapIndex == lastSwapIndexTemp) {
                return;
            }
        }
    }

    /**
     * 优化：正反方向串行走排序
     *
     * @param arr 待排序数组
     */
    public static void optBubbleSortWithTwoDirection(int[] arr) {
        System.out.print("原数组：");
        PrintUtil.printArray(arr);

        int low = 0;
        int high = arr.length - 1;

        while (low < high) {

            for (int j = high; j > low; j--) {
                if (arr[j - 1] > arr[j]) {
                    SwapUtil.swapArray(arr, j - 1, j);
                }
            }
            low++;

            for (int i = low; i < high; i++) {
                if (arr[i] > arr[i + 1]) {
                    SwapUtil.swapArray(arr, i, i + 1);
                }
            }
            high--;
        }

        System.out.print("排序后数组：");
        PrintUtil.printArray(arr);
    }

    public static void main(String[] args) {

        int[] arr = {2, 9, 5, 8, 3, 6, 4, 1, 7, 10, 14};

        // 最基本的冒泡排序
//        baseBubbleSort(arr);

        // 优化：标记是否发生交换
//        optBubbleSortWithSwap(arr);

        // 优化：记录每趟排序的最终交换位置
//        optBubbleSortWithSwapLocation(arr);

        // 优化：正反方向串行排序
        optBubbleSortWithTwoDirection(arr);

    }
}
