package com.jjq.ap.backtrace;

import java.util.LinkedList;
import java.util.List;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/9/12
 * @desc 有两个数组nums[1,3,2,5,4]和values[1,2,3,4,5]
 * 第i次从values取值values[i-1],从nums可以从开头和结尾取值记为a,
 * 求values[i-1]*a,所有可能和的最大值
 */
public class MaxValueTotal {


    static List<List<Integer>> res = new LinkedList<>();

    public static void main(String[] args) {
        final int[] nums = new int[]{1,3,2,5,4};
        final int[] values = new int[]{1,2,3,4,5};
        List<List<Integer>> res = maxValueTotal(nums, values);
        System.out.println(res.toString());
    }

    public static List<List<Integer>> maxValueTotal(int[] nums, int[] values) {
        LinkedList<Integer> trace = new LinkedList<>();
        LinkedList<Integer> _res = new LinkedList<>();
        backtrace(nums, values, trace, _res);
        return res;
    }

    public static void backtrace(int[] nums, int[] values, LinkedList<Integer> trace, LinkedList<Integer> _res) {
        if (trace.size() == nums.length) {
            res.add(new LinkedList<>(_res));
            return;
        }
        for (int i = 0; i < values.length; i++) {
            if (trace.contains(nums[i])) {
                continue;
            }
            trace.add(nums[i]);
            _res.add(nums[i]*values[i]);
            backtrace(nums, values, trace, _res);
            trace.removeLast();
        }
    }
}
