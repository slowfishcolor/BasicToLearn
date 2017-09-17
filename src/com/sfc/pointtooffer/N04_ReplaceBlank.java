package com.sfc.pointtooffer;

/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * 思路，第一遍遍历，计算多少个空格，之后从后向前复制
 *
 * Created by Prophet on 2017/9/17.
 */
public class N04_ReplaceBlank {

    public static String replaceSpace(StringBuffer str) {

        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }

        int length = str.length() + count * 2;
        char[] chars = new char[length];
        str.getChars(0, str.length(), chars, 0);

        int i = str.length() - 1;
        int j = length - 1;
        while (i >= 0 && count > 0) {
            if (chars[i] == ' ') {
                chars[j--] = '0';
                chars[j--] = '2';
                chars[j--] = '%';
                i--;
                count--;
            } else {
                chars[j--] = chars[i--];
            }
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("Hello World");
        System.out.println(replaceSpace(str));
    }

}
