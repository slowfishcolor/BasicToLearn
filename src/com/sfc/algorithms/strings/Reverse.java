package com.sfc.algorithms.strings;

/**
 * 对于一个字符串，请设计一个算法，只在字符串的单词间做逆序调整，也就是说，字符串由一些由空格分隔的部分组成，你需要将这些部分逆序。
 * 给定一个原字符串A和他的长度，请返回逆序后的字符串。

 测试样例：
 "dog loves pig",13
 返回："pig loves dog"

 * Created by Prophet on 2017/8/26.
 */
public class Reverse {

    // 先整体逆序，再逐个单词逆序
    public static String reverseSentence(String A, int n) {
        if (A == null || A.length() == 1) return A;

        char[] chars = A.toCharArray();

        // 整体逆序
        reverse(chars, 0, chars.length - 1);

        int begin = 0;
        int end = 0;
        // 逐个单词逆序
        for (; end < chars.length; end++) {
            if (chars[end] == ' ') {
                reverse(chars, begin, end - 1);
                begin = end + 1;
            }
        }
        // 处理最后一个单词
        if (begin != end) {
            reverse(chars, begin, end - 1);
        }

        return String.copyValueOf(chars);
    }

    private static void reverse(char[] chars, int beginIndex, int endIndex) {
        char t;
        while (beginIndex < endIndex) {
            t = chars[beginIndex];
            chars[beginIndex] = chars[endIndex];
            chars[endIndex] = t;
            beginIndex++;
            endIndex--;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseSentence("hello world", 11));
    }
}
