package com.gavinandre.kotlininteroperatewithjava;

public class VarArgsDemo<T> {
    static VarArgsDemo vad = new VarArgsDemo();

    public static void main(String... agrs) {
        System.out.println(vad.append("a", "b", "c"));
        System.out.println(vad.append(1, 2, 3));
        System.out.println(vad.append(1, 2, "3"));
    }

    public String append(T... element) {
        StringBuilder result = new StringBuilder();
        for (T e : element) {
            result.append(e);
        }
        return result.toString();
    }
}