package com.wolf.datastructure.sort;

/**
 * @Description 快速排序
 * @Author wangqikang
 * @Date 2019-07-14 10:06
 */
public class QuickSort {

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = partition(arr, left, right);
            quickSort(arr, left, mid - 1);
            quickSort(arr, mid + 1, right);
        }
    }

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
    }
}
