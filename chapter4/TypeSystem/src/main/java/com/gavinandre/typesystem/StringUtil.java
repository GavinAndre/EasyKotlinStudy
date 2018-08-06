package com.gavinandre.typesystem;

public class StringUtil {

    public static int getLength1(String str) {
        return str.length();
    }

    public static int getLength2(String str) throws Exception {
        if (null == str) {
            throw new Exception("str is null");
        }

        return str.length();
    }

}
