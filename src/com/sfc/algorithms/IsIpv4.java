package com.sfc.algorithms;

/**
 * 判断一个字符串是否为合法的十进制点IPv4地址，比如192.168.1.2
 * Created by Prophet on 2017/2/17.
 */
public class IsIpv4 {

    public static void main(String[] args) {
        System.out.println(isIpv4("192.168.0.1"));
    }

    public static boolean isIpv4(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        // 分割四段
        String[] parts = str.split("\\."); // 这些字符有 | , + , * , ^ , $ , / , | , [ , ] , ( , ) , - , . , \等, 因它们是正则表达式中的一部分, 所以如果想用该字符本身, 这些字符需要进行转义才能表示它本身；
        if (parts.length != 4) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            try {
                int n = Integer.parseInt(parts[i]);
                if (n < 0 || n > 255) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }
}
