package com.jjq.ap.array;

/**
 * @author jiangjunqing
 * @version 1.0.0
 * @date 2023/2/8
 * @desc 零钱问题 https://leetcode.cn/problems/coin-change
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
 * 你可以认为每种硬币的数量是无限的。
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 25;
        int i = coinChange(coins, amount);
        System.out.println("result:" + i);
    }

    /**
     * 动态规划
     * dp[j] ：凑足总额为j的最少硬币个数
     * dp[j-coins[i]] +1 = dp[j]
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        int[] dp  = new int[amount+1];
        dp[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = amount; j > coins[i]; j -= coins[i]) {
                if (dp[j] == 0) {
                    dp[j] = Integer.MAX_VALUE;
                }
                dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
            }
        }
        return dp[amount];
    }
}
