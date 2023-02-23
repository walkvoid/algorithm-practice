package com.jjq.ap.num;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/7/17
 * @desc 数字字符串乘法
 * 当有两个数都很大的,比如126787164817649837492873423 * 923857907540938705948702398,long型已经会溢出了
 * 此时可以把两个乘数看出字符串处理
 *
 * 刷题按照:
 * - [拉不拉东的算法小抄](https://labuladong.gitee.io/algo/)
 * - [看云的算法文档](https://www.kancloud.cn/techding/algorithm/2187185)
 */
public class NumberStringMultiply {





    public static void main(String[] args) {

    }


    /**
     * 2312+342
     * @param args1
     * @param args2
     * @return
     */
    public static String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int cl1 = chars1.length;
        int cl2 = chars2.length;
        char[] result = new char[cl1+cl2];
        for (int i=cl1-1;i>=0;i--) {
            int ci = chars1[i] -'0';
            for (int j=cl2-1;j>=0;j--) {
                int cj = chars2[j] -'0';
                result[i+j+1] += ci*cj;
            }
        }
        char[] res = new char[cl1+cl2];
        for (int r=result.length-1;r>0;r--) {
            res[r] = (char) ((result[r]%10) + '0');
            result[r-1] = (char) (result[r]/10 + result[r-1]);
        }
        if (result[0] !='\u0000') {
            res[0] = (char) (result[0] + '0');
            return new String(res);
        }else {
            return new String(res,1,res.length-1);
        }



    }
}
