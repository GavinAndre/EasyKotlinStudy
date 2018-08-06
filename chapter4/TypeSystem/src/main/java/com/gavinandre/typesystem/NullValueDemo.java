package com.gavinandre.typesystem;

public class NullValueDemo {
    public static void testNull() {
        String str = null;
        Integer itr = null;
        Double dbl = null;

        String myStr = (String) null;
        Integer myItr = (Integer) null;
        Double myDbl = (Double) null;

        //Java中null可以赋值给引用变量,不能讲null赋给基本类型变量
        // int i = null;
        // short s = null;
        // byte b = null;

        //但是如果将null赋值给包装类object，然后将object赋给各自的基本类型，编译器不会报，但是你将会在运行时期遇到空指针异常。这是Java中的自动拆箱导致的
        Integer nullInt = null;
        //编译器允许这么赋值, 但是在运行时抛 NullPointerException；Integer的默认值是null而不是0。当把null值传递给一个int型变量的时候自动装箱将会返回空指针异常。
        // int anotherInt = nullInt;

        Integer iAmNull = null;
        if (iAmNull instanceof Integer) {
            System.out.println("null is instance of Integer");
        } else {
            System.out.println("null is NOT an instance of Integer");
        }
    }
}
