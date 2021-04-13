package com.jjq.ap.sort;

import java.util.Arrays;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/4/13
 * @desc 快排
 */
public class QuickSort {

    public static int[] SRC_ARRAY = {4,3,7,1,5,2,6};

    public static void main(String[] args) {
        quickSort(SRC_ARRAY, 0, SRC_ARRAY.length-1);
        System.out.println(Arrays.toString(SRC_ARRAY));
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start<end) {
            int pivot = getPivot(arr, start, end);
            quickSort(arr, pivot+1, end);
            quickSort(arr, start, pivot-1);
        }
    }



    private static int getPivot(int[] arr, int start, int end) {
        int ref = arr[start];
        while (start < end) {
            while (start<end && arr[end]>=ref) {
                end--;
            }
            if (start < end) {
                arr[start] = arr[end];
                //第一次执行后:{2,3,7,1,5,2,6};
                //第二次执行后:{2,3,1,1,5,7,6};
            }

            while (start<end && arr[start] <=ref) {
                start++;
            }
            if (start < end) {
                arr[end] = arr[start];
                //第一次执行后:{2,3,7,1,5,7,6};
                //第二次执行后:{2,3,1,1,5,7,6};
            }
        }
        arr[start] = ref;
        return start;
    }

}
