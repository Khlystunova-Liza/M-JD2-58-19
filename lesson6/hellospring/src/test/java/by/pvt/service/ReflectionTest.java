package by.pvt.service;

import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class ReflectionTest {

    @Test
    public void testCreateInstance(){
      MyClass myClass = new MyClass();
      assertNotNull(myClass);
    }

    @Test
    public void testCreateInstanceReflection(){
        try {
            Class clazz  = Class.forName("by.pvt.service.MyClass");
            Object o = clazz.getDeclaredConstructor().newInstance();
            assertNotNull(o);
            assertTrue(o instanceof MyClass);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}


class MyClass{}