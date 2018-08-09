package com.gavinandre.generics;

import java.util.ArrayList;
import java.util.List;

public class ArrayCovariantDemo {

    public void covariantDemo() {
        // Java中数组是协变的
        Integer[] ints = new Integer[3];
        ints[0] = 0;
        ints[1] = 1;
        ints[2] = 2;
        // 在Java中，因为 Integer 是 Number 的子类型，
        // 数组类型 Integer[] 也是 Number[] 的子类型，
        // 因此在任何需要 Number[] 值的地方都可以提供一个 Integer[] 值
        Number[] numbers = new Number[3];
        numbers = ints;
        for (Number n : numbers) {
            System.out.println(n);
        }

        // 泛型不是协变的
        List<Integer> integerList = new ArrayList<>();
        integerList.add(0);
        integerList.add(1);
        integerList.add(2);
        List<Number> numberList = new ArrayList<>();
        // List<Integer> 不是 List<Number> 的子类型，
        // 试图在要求 List<Number> 的位置提供 List<Integer> 是一个类型错误
        // numberList = integerList;

        // <? extends T>实现了泛型的协变,但Java为了保护其类型一致，
        // 禁止向List<? extends Number>添加任意对象，不过可以添加null
        // 可以用来安全的读取数据 out T
        List<? extends Number> list = new ArrayList<Number>();
        // list.add(new Integer(1)); //error
        List<? extends Number> list1 = new ArrayList<Integer>();
        List<? extends Number> list2 = new ArrayList<Float>();
        list1.add(null);
        list2.add(null);
        // list1.add(new Integer(1)); // error
        // list2.add(new Float(1.1f)); // error

    }

    public void contravariantDemo() {
        // <? super T>实现了泛型的逆变,
        // 我们不能往List<? super Number >中添加Number的任意父类对象。
        // 但是可以向List<? super Number >添加Number及其子类对象
        // 可以用来安全的写入数据 in T
        List<? super Number> list3 = new ArrayList<Number>();
        List<? super Number> list4 = new ArrayList<Object>();
        list3.add(new Integer(3));
        list4.add(new Float(4));
    }

}
