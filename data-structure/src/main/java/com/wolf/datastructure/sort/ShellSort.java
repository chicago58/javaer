package com.wolf.datastructure.sort;

/**
 * @Description
 * @Author wangqikang
 * @Date 2019-07-14 10:20
 */
public class ShellSort {
    public static void shellSort(int[] arr, int n) {
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < n; j += gap) {
                    if (arr[j] < arr[j - gap]) {
                        int temp = arr[j];
                        int k = j - gap;
                        while (k >= 0 && arr[k] > temp) {
                            arr[k + gap] = arr[k];
                            k -= gap;
                        }
                        arr[k + gap] = temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
