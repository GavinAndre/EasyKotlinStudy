package com.gavinandre.kotlininteroperatewithjava;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class JavaCallingKotlinCodeTest {

    @Test
    public void testProperty() {
        Department d = new Department();
        d.setId(1);
        d.setName("技术部");
        d.setBig("Y");
        d.setOpen(true);

        Assert.assertTrue(1 == d.getId());
        Assert.assertTrue("技术部".equals(d.getName()));
        Assert.assertTrue("Y".equals(d.isBig()));
        Assert.assertTrue(d.isOpen());

        System.out.println(d.NO = 10);

        //在Java访问的innerID时候，是通过Companion来访问
        System.out.println(Department.Companion.getInnerID());
        //使用@JvmField注解的字段innerName ，Kotlin编译器会把它的访问权限设置是public的，这样我们就可以这样访问这个属性字段了
        System.out.println(Department.innerName);

        Department.Companion.getObjectID(); // OK
        Department.Companion.getObjectName(); // OK, 唯一的工作方式
        Department.getObjectID(); // ALSO OK
        // Department.getObjectName(); // ERROR

    }

    @Test
    public void testPackageFun() {
        KotlinExampleKt.f1();
        KotlinExampleKt.f2();
        System.out.println(KotlinExampleKt.getP());
        System.out.println(KotlinExampleKt.swap("abc", 0, 1));

        MyKotlinExample.f3();
        MyKotlinExample.f4();
    }
}
