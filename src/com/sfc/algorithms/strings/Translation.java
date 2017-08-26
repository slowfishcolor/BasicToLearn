package com.sfc.algorithms.strings;

/**
 *
 * 对于一个字符串，请设计一个算法，将字符串的长度为len的前缀平移到字符串的最后。

 给定一个字符串A和它的长度，同时给定len，请返回平移后的字符串。

 测试样例：
 "ABCDE",5,3
 返回："DEABC"

 * Created by Prophet on 2017/8/26.
 */
public class Translation {

    public String stringTranslation(String A, int n, int len) {
        // write code here
        if (A == null || A.length() <= 1 || n >= A.length()) return A;

        char[] chars = A.toCharArray();

        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);

        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int beginIndex, int endIndex) {
        char t;
        while (beginIndex < endIndex) {
            t = chars[beginIndex];
            chars[beginIndex] = chars[endIndex];
            chars[endIndex] = t;
            beginIndex++;
            endIndex--;
        }
    }
}
