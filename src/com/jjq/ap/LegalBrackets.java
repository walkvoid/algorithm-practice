package com.jjq.ap;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/6/20
 * @desc 合法的括号  https://labuladong.gitee.io/algo/5/40/
 */
public class LegalBrackets {


    public static String[] TEST_STRS = new String[]{"()))((", "()()()","(((()))))","(((())))"};

    public static void main(String[] args) {
        for (int i=0;i<TEST_STRS.length; i++) {
            boolean result = legalBrackets(TEST_STRS[i]);
            System.out.println(TEST_STRS[i] + "==>" + result);
        }

    }


    public static boolean legalBrackets(String str) {
        int left = 0;
        for (int i=0;i<str.length(); i++) {
            if ('(' == str.charAt(i)) {
                left++;
            }else {
                left--;
            }
            if (left<0) {
                return false;
            }
        }
        return left==0;
    }
}
