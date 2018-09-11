package com.gavinandre.kotlinoop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SingletonDemoTest {

    @Test
    public void test() {
        SingletonDemo singleton = SingletonDemo.getInstance();
        //SingletonDemo singleton2 = new SingletonDemo(); //error, cannot private access
    }
}
