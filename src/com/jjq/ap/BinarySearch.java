package com.jjq.ap;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/5/11
 * @desc todo
 */
public class BinarySearch {

    public static int[] SRC_ARRAY = {1,3,7,11,15,22,26,34,39,47,50,56,61,69,70};

    public static void main(String[] args) {
        int i = binarySearch(SRC_ARRAY, 56);
        System.out.println("result:"+ i);


    }

    /**
     * 二分搜索
     * @param arr
     * @param value
     * @return 成功返回下标,否则返回-1
     */
    public static int binarySearch(int[] arr, int value) {
        //return binarySearch(arr, 0, arr.length-1, value);
        return binarySearch2(arr, 0, arr.length-1, value);
    }

    public static int binarySearch(int[] arr, int start, int end, int value) {
        int mid = end+(end-start)/2;
        if (arr[mid] == value) {
            return mid;
        }
        if (start == end) {
            return -1;
        }
        if (arr[mid] < value) {
            return binarySearch(arr, mid+1, end, value);
        }
        if (arr[mid] > value) {
            return binarySearch(arr, start, mid-1, value);
        }
        return -1;
    }

    //public static int[] SRC_ARRAY = {1,3,7,11,15,22,26,34,39,47,50,56,61,69,70};
    public static int binarySearch2(int[] arr, int start, int end, int value) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == value) {
                return mid;
            }
            if (arr[mid] < value) {
                start = mid+1;
            }
            if (arr[mid] > value) {
                end = mid-1;
            }
        }
        return -1;
    }
}
