package com.gavinandre.generics;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TypeWildcardTest {

    TypeWildcardDemo typeWildcardDemo = new TypeWildcardDemo();

    @Test
    public void testExtendTypeWildcard() {
        typeWildcardDemo.extendWildcardDemo();
    }

    @Test
    public void testSuperTypeWildcard() {
        typeWildcardDemo.superWildcardDemo();
    }

}
