package com.gavinandre.generics;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ArrayCovariantTest {

    ArrayCovariantDemo arrayCovariantDemo = new ArrayCovariantDemo();

    @Test
    public void testCovariant() {
        arrayCovariantDemo.covariantDemo();
    }

    @Test
    public void testContravariant() {
        arrayCovariantDemo.contravariantDemo();
    }

}
