package com.jjq.ap.other;

/**
 * @author jiangjunqing
 * @version v1.0.0
 * @date 2023/2/22
 * @desc 爬楼梯 https://leetcode.cn/problems/climbing-stairs/
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class ClimbStairs {

    public static void main(String[] args) {
        int i = climbStairs(4);
        System.out.println("result:" + i);
    }

    /**
     * dp[i]:爬i阶楼梯需要的方法
     * dp[i] = dp[i-1] + dp[i-2]
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n ; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
