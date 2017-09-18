package com.sfc.other;

/**
 * 其对象的引用都是存储在栈中的，如果是编译期已经创建好(直接用双引号定义的)的就存储在常量池中，
 * 如果是运行期（new出来的）才能确定的就存储在堆中。
 * 对于equals相等的字符串，在常量池中永远只有一份，在堆中有多份。
 *
 * 这里解释一下，对于通过 new 产生一个字符串（假设为 ”china” ）时，会先去常量池中查找是否已经有了 ”china” 对象，
 * 如果没有则在常量池中创建一个此字符串对象，然后堆中再创建一个常量池中此 ”china” 对象的拷贝对象。
 *
 * 也就是有道面试题： String s = new String(“xyz”); 产生几个对象？
 * 一个或两个。如果常量池中原来没有 “xyz”, 就是两个。如果原来的常量池中存在 “xyz” 时，就是一个。
 *
 * Created by Prophet on 2017/9/18.
 */
public class StringTest {
    public static void main(String[] args) {
        String a = "hello";
        String b = new String("hello");
        String c = "he" + "llo";
        String d = new String("hello"); // 产生一个对象
        String e = new String("world"); // 产生两个对象，一个在常量池中，一个是在堆中的拷贝
        System.out.println(a == b);         // false  a 在常量区，b 在堆，不是指向同一个对象
        System.out.println(a == c);         // true   c 编译期已经确定其值，与 a 指向同一个常量对象
        System.out.println(a.equals(b));    // true   String 覆写了 equals 方法，可以进行对象的比较
        System.out.println(b == d);         // false  运行时创立的不是同一个对象
    }
}
