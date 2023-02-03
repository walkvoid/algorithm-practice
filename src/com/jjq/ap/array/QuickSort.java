package com.jjq.ap.array;

import java.util.Arrays;

/**
 * @author jiangjunqing
 * @version 1.0.0
 * @date 2021/4/13 2023/2/3
 * @desc 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {4,3,7,1,5,2,6};
        quicksort(arr, 0, arr.length - 1);
        System.out.println("result:" + Arrays.toString(arr));
    }

    /**
     *
     * @param arr 待排序的数组
     * @param start 需要排序元素的初始下标
     * @param end   需要排序元素的结束下标
     */
    public static void quicksort(int[] arr, int start, int end){
        if (start >= end) {
            return;
        }
        int pivot = calcPivot(arr, start, end);
        //首次调用后：[2,1,3,4,5,6,7]
        quicksort(arr, start, pivot-1);
        quicksort(arr,pivot+1, end);
    }

    /**
     * 获取左边大右边小分界点的数组下标
     * @param arr 待排序的数组
     * @param start 需要排序元素的初始下标
     * @param end   需要排序元素的结束下标
     */
    public static int calcPivot(int[] arr, int start, int end) {
        //默认取第一个为参照值，即要找出比ref小的值放左边，比ref大的放右边
        int ref = arr[start];
        while (start < end) {
            //从数组尾部开始比较，直到找到第一个比参照值ref小的
            while (arr[end] >= ref) {
                end--;
            }
            //退出循环，end此时指向比ref小的值下标,将这个值交换到前面去
            //#因为上一步已经end--，有可能此时start>end这个判断所以需要加上
            if (start < end) {
                arr[start] = arr[end];
            }

            //类似的，从数组头部开始比较，直到找到第一个比参照值ref大大
            while (start< end && arr[start] <= ref){
                start++;
            }
            if (start < end) {
                arr[end] = arr[start];
            }
        }
        //需要将ref这个值赋值到start或者end，此时start=end， 不然ref这个值将会丢失
        arr[start] = ref;

        return start;
    }
}
