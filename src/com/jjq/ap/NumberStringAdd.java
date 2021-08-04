package com.jjq.ap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/7/17
 * @desc 数字字符串加法
 * 当有两个数都很大的,比如126787164817649837492873423 + 923857907540938705948702398,long型已经会溢出了
 * 此时可以把两个加数看出字符串处理
 */
public class NumberStringAdd {





    public static void main(String[] args) {
        List<String> testList = Arrays.asList(
                "2316@347@2663","347@2316@2663",
                "4999@1@5000","1@4999@5000",
                "9999@1@10000","1@9999@10000",
                "785465@424525@1209990",
                "99999999999999999999999999999@1@100000000000000000000000000000"
                );
        for (String item : testList) {
            String[] split = item.split("@");
            String result = add(split[0], split[1]);
            if (result.equals(split[2])) {
                System.out.println("==pass== "+ split[0] + "+"+ split[1] +"=" + split[2]);
            } else {
                System.out.println("==error== "+ split[0] + "+"+ split[1] +"!=" + split[2]);
            }
        }
    }

    public static String add(String args1, String args2) {
        if (args1.length()<=0 || args2.length()<=0) {
            throw new IllegalArgumentException();
        }
        int maxLength = Math.max(args1.length(), args2.length());
        byte[] results = new byte[maxLength+1];
        int flag = 0;
        for (int i=0; i<maxLength; i++) {
            char c1, c2;
            if (maxLength == args1.length()) {
                c1 = args1.charAt(args1.length() - i - 1);
                c2 = args2.length()-i-1 >=0 ? args2.charAt(args2.length() - i - 1) :'0';
            }else {
                c1 = args2.charAt(args2.length() - i - 1);
                c2 = args1.length()-i-1 >=0 ? args1.charAt(args1.length() - i - 1) :'0';
            }
            if(c1-48+c2-48 + flag>=10) {
                results[results.length - 1 - i] = (byte) (c1 - 48 + c2 - 48 + flag - 10 + 48);
                flag =1;
            }else {
                results[results.length - 1 - i] = (byte) (c1 - 48 + c2 - 48 + flag + 48);
                flag=0;
            }
        }
        if (flag ==1) {
            results[0] = 49;
        }
        return new String(results).trim();

    }
}
