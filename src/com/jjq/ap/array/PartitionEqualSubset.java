package com.jjq.ap.array;

/**
 * @author jiangjunqing
 * @version 1.0.0
 * @date 2023/2/10
 * @desc 等分数组的子集
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * https://leetcode.cn/problems/partition-equal-subset-sum/
 *
 * 代码随想录：https://programmercarl.com/%E8%83%8C%E5%8C%85%E7%90%86%E8%AE%BA%E5%9F%BA%E7%A1%8001%E8%83%8C%E5%8C%85-1.html
 */
public class PartitionEqualSubset {

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        boolean partition = canPartition(nums);
        System.out.println("result:" + partition);
    }

    /**
     * dp[j]表示，容量为j的背包能装的最大质量
     * 从dp[j-nums[i]) => dp[j]
     * dp[j-nums[i]) + nums[i] = dp[j]
     * @param nums
     * @return
     */
    public static boolean canPartition(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        int half = sum / 2;
        int[] dp = new int[half+1];
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = half; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-nums[i]]+ nums[i]);
            }
        }
        return dp[half] == half;
    }
}
