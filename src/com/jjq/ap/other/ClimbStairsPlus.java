package com.jjq.ap.other;

/**
 * @author jiangjunqing
 * @version v1.0.0
 * @date 2023/2/22
 * @desc 爬楼梯升级版 https://programmercarl.com/0070.%E7%88%AC%E6%A5%BC%E6%A2%AF%E5%AE%8C%E5%85%A8%E8%83%8C%E5%8C%85%E7%89%88%E6%9C%AC.html#%E6%80%9D%E8%B7%AF
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1，2，3,...m个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class ClimbStairsPlus {

    public static void main(String[] args) {
        int i = climbStairsPlus(4,3);
        System.out.println("result:" + i);
    }

    /**
     * dp[i]:爬i阶楼梯需要的方法
     * dp[i] = dp[i-1] + dp[i-2]
     * @param n
     * @return
     */
    public static int climbStairsPlus(int n, int m) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n ; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
