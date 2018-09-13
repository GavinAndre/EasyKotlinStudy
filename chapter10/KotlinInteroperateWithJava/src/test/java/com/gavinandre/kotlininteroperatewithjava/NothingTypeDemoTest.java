package com.gavinandre.kotlininteroperatewithjava;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class NothingTypeDemoTest {
    @Test
    public void testNothingTypeDemo(){
        NothingTypeDemo nothingTypeDemo = new NothingTypeDemo();
        System.out.println(nothingTypeDemo.emptyList().getClass());
        System.out.println(nothingTypeDemo.emptyList2().getClass());
    }
}
