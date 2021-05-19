package ema;

import org.junit.Assert;

//import org.junit.Test;

public class Test1 extends Assert{

    Class<?> anyObject(Object val) {
        return val != null ? val.getClass() : null;
    }

    //@Test
    public void anyObjectProof() {
        System.out.println(any(new int[]{}));
    }


    <T> Class<?> anyGeneric(T val) {
        return val != null ? val.getClass() : null;
    }

    //@Test
    public void anyAsObject_alsoViaGenerics() {
        assertEquals(String.class, anyObject("a string"));
        assertEquals(String.class, anyGeneric("a string"));
        // atomic arrays are Ok
        assertEquals(boolean[].class, anyGeneric(new boolean[]{}));

//        System.out.println(int[].class);
//        System.out.println(anyGeneric(new int[]{}));

        assertEquals(int[].class, anyGeneric(new int[]{}));
        // atomic: auto-boxed and thus not Ok
        assertEquals(Boolean.class, anyObject(true));
        assertEquals(Boolean.class, anyGeneric(true));
        assertEquals(Integer.class, anyObject(125));
        assertEquals(Integer.class, anyGeneric(125));
    }

// with overloading

    Class<?> any(Object val) {
        return val != null ? val.getClass() : null;
    }

    Class<?> any(boolean val) {
        return boolean.class;
    }

    Class<?> any(int val) {
        return int.class;
    }

    //@Test
    public void any_overloadedForAtomic() {
        assertEquals(String.class, any("a string"));
        assertEquals(Boolean.class, any(Boolean.TRUE));
        assertEquals(Integer.class, any(Integer.valueOf(125)));
        assertEquals(boolean[].class, any(new boolean[]{}));
        assertEquals(int[].class, any(new int[]{}));
        // atomic
        assertEquals(boolean.class, any(true));
        assertEquals(int.class, any(125));
    }
}

