package com.jjq.ap.array;

/**
 * @author jiangjunqing
 * @version 1.0.0
 * @date 2023/2/5
 * @desc 最长回文子串
 * https://leetcode.cn/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "dasabddbadhffh";
        String result = longestPalindrome(s);
        System.out.println("result:" + result);
    }

    /**
     * 动态规划
     * 1.dp[i][j],s子字符串从下标i到j之间是否为回文串,i<=j
     * 2。如果dp[i][j]是回文串，且s[i-1]==s[j+1],那么dp[i-1][j+1]也是回文串
     * 换句话说：如果dp[i+1][j-1]是回文串，且s[i]==s[j],那么dp[i][j]也是回文串
     * 3。i是越来越小的，j越来越大，所以i从大到小遍历，j从小到大遍历
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if(s == null || s.equals("")) return s;

        //tempMaxLength:回文串最大长度，start：回文串的起始位置，end：回文串的结束位置
        int tempMaxLength = 0, start = 0, end = 0;
        int[][] dp = new int[s.length()][s.length()];

        //转成数组方便操作
        char[] chars = s.toCharArray();
        for (int i = chars.length-1; i >= 0; i--) {
            for (int j = 0; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    if (j-i <= 1 || dp[i+1][j-1] > 0) { //b bb || abddba
                        dp[i][j] = 1;
                    }
                    if (dp[i][j] > 0 && j-i+1 > tempMaxLength) {
                        start=i;
                        end=j;
                        tempMaxLength=j-i+1;
                    }
                }
            }
        }
        return s.substring(start, end+1);
    }
}
