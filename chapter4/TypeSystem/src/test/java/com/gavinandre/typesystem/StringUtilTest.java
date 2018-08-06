package com.gavinandre.typesystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StringUtilTest {

    @Test
    public void testGetLength1() {
        StringUtil util = new StringUtil();
        util.getLength1(null);
    }

    @Test
    public void testGetLength2() {
        StringUtil util = new StringUtil();
        try {
            util.getLength2(null);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
