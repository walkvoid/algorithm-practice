package com.jjq.ap.array;

import java.util.Arrays;

/**
 * @author jiangjunqing
 * @version 1.0.0
 * @date 2023/2/8 2023/2/22
 * @desc 零钱问题 https://leetcode.cn/problems/coin-change 322
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
 * 你可以认为每种硬币的数量是无限的。
 *
 * 参考：https://labuladong.gitee.io/algo/di-er-zhan-a01c6/dong-tai-g-a223e/dong-tai-g-1e688/
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {2}; int amount = 3; // -1
        //int[] coins = {1,2,5}; int amount = 11; // 3

        int i = coinChange2(coins, amount);
        System.out.println("result:" + i);
    }

    /**
     * dp[i]: 凑成总金额为i的最少硬币数
     * 已知dp[i-nums[j]] 则dp[i] = dp[i-nums[j]] +1
     * 需要注意：dp[i-nums[j]]等于初始值Integer.MAX_VALUE（无法凑成），那么dp[i]也跳过（无法凑成）
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        //初始化为最大值
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int j = 0; j < coins.length; j++) {
            for (int i = coins[j]; i <= amount; i++) {
                if (dp[i-coins[j]] == Integer.MAX_VALUE) {
                    continue;
                }
                dp[i] = Math.min(dp[i-coins[j]] + 1, dp[i]);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1: dp[amount];
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
        if (amount < 0) {
            return -1;
        }
        int[] dp  = new int[amount+1];
        //初始化dp数组
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                //dp[j] = dp[j-coins[i]] +1; 但是dp[j]可能已经计算过了，所以这里取更小的那个
                if (dp[j-coin] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount] ;
    }
}
