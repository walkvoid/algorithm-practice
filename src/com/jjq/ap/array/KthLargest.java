package com.jjq.ap.array;

/**
 * @author jiangjunqing
 * @version 1.0.0
 * @date 2023/2/3
 * @desc 数组中第k大的元素，时间复杂度为O(n)
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/
 */
public class KthLargest {

    public static void main(String[] args) {
        //int[] nums = {3,2,3,1,2,4,5,5,6};
        int[] nums = {4,3,7,1,5,2,6};
        int k = 3;
        int kthLargest = findKthLargest(nums, k);
        System.out.println("findKthLargest,result:" + kthLargest);

    }

    /**
     * 使用变种快排，每次排序确定k属于那一边，只排k在的那一边
     * 传统的快排时间复杂度是O(logN）
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        return find(nums, k, 0, nums.length - 1);
    }

    /**
     *
     * @param nums
     * @param k
     * @param start
     * @param end
     * @return
     *  pivot = 3
     *  k = 3, 5;
     */
    public static int find(int[] nums, int k, int start, int end) {
        int pivot = calcPivot(nums, start, end);
        if (pivot + 1 == k) {
            return pivot;
        }
        //首次调用后：[5, 6, 7，4，2, 1, 3]
        if(pivot + 1 > k) {
            find(nums, k, start, pivot-1);
        }

        if(pivot + 1 < k) {
            find(nums, k-pivot-1, pivot + 1, end);
        }
        return -1;
    }

    /**
     * 获取左边小右边大（逆序）分界点的数组下标
     * @param arr 待排序的数组
     * @param start 需要排序元素的初始下标
     * @param end   需要排序元素的结束下标
     */
    public static int calcPivot(int[] arr, int start, int end) {
        //默认取第一个为参照值，即要找出比ref小的值放左边，比ref大的放右边
        int ref = arr[start];
        while (start < end) {
            //从数组尾部开始比较，直到找到第一个比参照值ref大的
            while (arr[end] <= ref) {
                end--;
            }
            //退出循环，end此时指向比ref小的值下标,将这个值交换到前面去
            //#因为上一步已经end--，有可能此时start>end这个判断所以需要加上
            if (start < end) {
                arr[start] = arr[end];
            }

            //类似的，从数组头部开始比较，直到找到第一个比参照值ref小的
            while (start< end && arr[start] >= ref){
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
