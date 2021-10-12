package com.jjq.ap.backtrace;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/9/12
 * @desc 回溯算法--全排列,有n个数,1,2,3,...n,求出所有的排列组合
 */
public class AllArrange {

    static List<List<Integer>> res = new LinkedList<>();

    public static void main(String[] args) {
        final int[] arr = new int[]{1,2,3};
        List<List<Integer>> res = allArrange(arr);
        System.out.println(res.toString());
    }

    public static List<List<Integer>> allArrange(int[] arr) {
        LinkedList<Integer> trace = new LinkedList<>();
        backtrace(arr, trace);
        return res;
    }

    public static void backtrace(int[] arr, LinkedList<Integer> trace) {
        if (trace.size() == arr.length) {
            res.add(new LinkedList<>(trace));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (trace.contains(arr[i])) {
                continue;
            }
            trace.add(arr[i]);
            backtrace(arr, trace);
            trace.removeLast();
        }
    }



}
