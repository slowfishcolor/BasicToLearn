package com.sfc.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by Prophet on 2017/2/14.
 */
public class BasicReflect {
    public static void main(String[] args) {

        A a = new A();
        // Object.getClass()
        Class c1 = a.getClass();
        // Object.class
        Class c2 = A.class;
        if (c1 == c2) System.out.println(c1.getName());
        try {
            // Class.forName()
            Class c3 = Class.forName("com.sfc.reflect.A");
            if (c1 == c3) System.out.println(c3.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 所有方法
        Method[] methods = c1.getMethods();
        for (Method m: methods) {
            System.out.println(m.getName());
        }

        // 所有构造函数
        Constructor[] constructors = c1.getConstructors();
        for (Constructor c: constructors) {
            System.out.println(c.getName());
        }

        // 声明过的方法
        Method[] methods1 = c1.getDeclaredMethods();
        for (Method m: methods1) {
            System.out.println(m.getName());
            // 方法的修饰符
            int mod = m.getModifiers();
            System.out.println(Modifier.toString(mod));
        }

        try {
            // 获取特定方法
            // (方法名,参数类型...)
            Method method = c1.getMethod("test", int.class, String.class);
            System.out.println(method.getName());
            // 执行该方法
            // (调用该方法的对象,执行该方法的具体参数...)
            method.invoke(a, 1,"test");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // 拿到公有field
            Field field = c1.getDeclaredField("i");
            Integer b = (Integer)field.get(a);
            System.out.println(b);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // 拿到私有field
            Field field = c1.getDeclaredField("j");
            // 可见性改为可见
            field.setAccessible(true);
            Integer b = (Integer)field.get(a);
            System.out.println(b);
        } catch (Exception e) {
            e.printStackTrace();
        }




    }
}
