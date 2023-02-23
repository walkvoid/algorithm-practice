package com.jjq.ap.array;

import java.util.Arrays;

/**
 * @author jiangjunqing
 * @version v1.0.0
 * @date 2023/2/23
 * @desc 零钱兑换2 https://leetcode.cn/problems/coin-change-ii/  518
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * 假设每一种面额的硬币有无限个。题目数据保证结果符合 32 位带符号整数。
 */
public class CoinChange2 {

    public static void main(String[] args) {
        //int[] coins = {2}; int amount = 3; //
        int[] coins = {1,2,5}; int amount = 11; //
        int i = coinChange(coins, amount);
        System.out.println("result:" + i);
    }

    /**
     * dp[i] 代表凑出总金额为i的硬币组合数
     * dp[i-coins[j]]
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0]=1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = dp[j]  + dp[j-coins[i]];
            }
            System.out.println("coin: i"+i +", dp:"+ Arrays.toString(dp));
        }
        return dp[amount];
    }
}
