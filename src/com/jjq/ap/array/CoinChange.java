package com.jjq.ap.array;

/**
 * @author jiangjunqing
 * @version 1.0.0
 * @date 2023/2/8
 * @desc 零钱问题 https://leetcode.cn/problems/coin-change
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
 * 你可以认为每种硬币的数量是无限的。
 *
 * 参考：https://labuladong.gitee.io/algo/di-er-zhan-a01c6/dong-tai-g-a223e/dong-tai-g-1e688/
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 3;
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
