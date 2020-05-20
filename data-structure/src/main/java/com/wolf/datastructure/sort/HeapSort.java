package com.wolf.datastructure.sort;

/**
 * @Description
 * @Author wangqikang
 * @Date 2019-07-14 10:23
 */
public class HeapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        int half = arr.length / 2;
        for (int i = half; i >= 0; i--) {
            maxHeap(arr, arr.length, i);
        }
    }

    private static void maxHeap(int[] arr, int length, int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;
        if (left < length && arr[left] > arr[index]) {
            largest = left;
        }
        if (right < length && arr[right] > arr[largest]) {
            largest = right;
        }
        if (index != largest) {
//            exchange(arr, largest, index);
            maxHeap(arr, length, largest);
        }
    }

    public static void main(String[] args) {

    }
}
