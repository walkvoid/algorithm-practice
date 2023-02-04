package com.jjq.ap.array;

/**
 * @author jiangjunqing
 * @version 1.0.0
 * @date 2023/2/4
 * @desc 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。要求时间复杂度为O(N)
 * https://leetcode.cn/problems/maximum-subarray/
 */
public class MaxSubArray {

    /**
     * 如果使用最暴力的穷举法
     * 9+8+7+6+...+1, 则时间复杂度为O（N^2），不符合要求
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        //int i = maxSubArray1(nums);
        int i = maxSubArray2(nums);
        System.out.println("result:" + i);
    }

    /**
     * 使用改进的穷举法
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
        //记录结果值，初始值为最小的int值
        int result = nums[0];
        //最大子序列开始的下标，初始化值为0，即默认从数组的第一个下标开始处理
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (temp > 0) {
                temp = temp+ nums[i];
            }else {
                temp = nums[i];
            }
            if (temp > result) {
                result = temp;
            }
        }
        return result;
    }

    /**
     * 使用动态规划法
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        //dp[i]表示，下标i之前数组元素的最大和
        //dp[0]=-2,
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
            if (dp[i] > result) {
                result = dp[i];
            }
        }
        return result;
    }



}
