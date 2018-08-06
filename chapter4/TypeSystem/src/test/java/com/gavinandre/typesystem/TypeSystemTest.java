package com.gavinandre.typesystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TypeSystemTest {

    @Test
    public void testTypeSystem() {
        Object str = "abc";
        if (str instanceof String) {
            int len = ((String) str).length();
            println(str + " is instanceof String");
            println("Length: " + len);
        } else {
            println(str + " is not instanceof String");
        }
        boolean is = "1" instanceof String;
        println(is);
    }

    void println(Object obj) {
        System.out.println(obj);
    }
}
