package com.sfc.algorithms.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * 对于两个字符串A和B，如果A和B中出现的字符种类相同且每种字符出现的次数相同，则A和B互为变形词，如 aab aba
 * 请设计一个高效算法，检查两给定串是否互为变形词。
 * 给定两个字符串A和B及他们的长度，请返回一个bool值，代表他们是否互为变形词。
 *
 * Created by Prophet on 2017/8/26.
 */
public class Transform {

    // 哈希方式处理
    public static boolean chkTransform(String A, int lena, String B, int lenb) {
        if (A == null || B == null || lena != lenb) return false;

        Map<Character, Integer> mapA = new HashMap<>();
        Map<Character, Integer> mapB = new HashMap<>();

        char[] charA = A.toCharArray();
        char[] charB = B.toCharArray();

        charToMap(charA, mapA);
        charToMap(charB, mapB);

        for (Map.Entry<Character, Integer> entry : mapA.entrySet()) {
            if ( !mapB.containsKey(entry.getKey()) || entry.getValue() != mapB.get(entry.getKey()) ) {
                return false;
            }
        }

        return true;
    }

    private static void charToMap (char[] chars, Map<Character, Integer> map) {
        int i = 0;
        for (char c : chars) {
            if (map.containsKey(c)) {
                i = map.get(c);
                map.put(c, ++i);
            } else {
                map.put(c, 0);
            }
        }
    }

    // 数组代替哈希处理
    public static boolean chkTransform_2(String A, int lena, String B, int lenb) {
        if (A == null || B == null || lena != lenb) return false;

        char[] charA = A.toCharArray();
        char[] charB = B.toCharArray();

        int[] map = new int[256];
        for (char c: charA) {
            map[c]++;
        }
        for (char c: charB) {
            if (--map[c] < 0) {
                return false;
            }
        }
        for (int i : map) {
            if (i != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(chkTransform_2("aab", 3, "aba", 3));

        char[] chars = "你好吗".toCharArray();
        System.out.print(chars[0] + 0);
    }
}
