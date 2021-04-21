package com.jjq.ap.sort;

import java.util.Arrays;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/4/22
 * @desc 冒泡排序
 */
public class BubbleSort {


    public static int[] SRC_ARRAY = {4,3,7,1,5,2,6};

    public static void main(String[] args) {
        bubbleSort(SRC_ARRAY);
        System.out.println(Arrays.toString(SRC_ARRAY));
    }




    private static void bubbleSort(int[] arr) {
        for (int i=0;i<arr.length; i++) {
            for (int j=0;j<arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp =arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }
}
