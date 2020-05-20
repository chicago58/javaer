package com.wolf.datastructure.sort;

import com.wolf.javacommon.util.PrintUtil;

/**
 * @Description 快速排序
 * @Author wangqikang
 * @Date 2019-07-14 10:06
 */
public class QuickSort {

    /**
     * 递归实现快速排序
     *
     * @param arr   待排序数组
     * @param left  待排序数组的第一个元素下标
     * @param right 待排序数组的最后一个元素下标
     */
    public static void quickSort(int[] arr, int left, int right) {
        if (arr == null || arr.length == 1) {
            return;
        }

        if (left < right) {
            int mid = partition(arr, left, right);
            quickSort(arr, left, mid - 1);
            quickSort(arr, mid + 1, right);
        }
    }

    /**
     * @param arr   待排序数组
     * @param left  待排序数组的第一个元素下标
     * @param right 待排序数组的最后一个元素下标
     * @return
     */
    public static int partition(int[] arr, int left, int right) {
        int key = arr[left];
        while (left < right) {
            // 从右往左
            while (left < right && arr[right] >= key) {
                right--;
            }
            arr[left] = arr[right];

            // 从左往右
            while (left < right && arr[left] <= key) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = key;
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {2, 9, 5, 8, 3, 6, 4, 1, 7, 10, 14};
        quickSort(arr, 0, arr.length - 1);
        PrintUtil.printArray(arr);
    }
}
