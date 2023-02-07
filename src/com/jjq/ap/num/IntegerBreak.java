package com.jjq.ap.num;

/**
 * @author jiangjunqing
 * @version 1.0.0
 * @date 2023/2/7
 * @desc 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * 返回 你可以获得的最大乘积 。
 * https://leetcode.cn/problems/integer-break/
 */
public class IntegerBreak {

    /**
     * 输入: n = 10
     * 输出: 36
     * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
     * @param args
     */
    public static void main(String[] args) {
        int i = integerBreak(10);
        System.out.println("result:"+ i);
    }

    /**
     * 动态规划
     * dp[i]:正整数i拆分后的最大乘机
     * d[j] * (i-j) = d[i]
     * 当然还必须考虑拆分成两个数的情况，即j（i-j）
     * @param num
     * @return
     */
    public static int integerBreak(int num){
        int[] dp = new int[num+1];
        dp[1] = 1;
        for (int i = 2; i < num+1; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(Math.max(dp[i], dp[j] * (i-j)), j*(i-j));
            }
        }
        return dp[num];
    }
}
