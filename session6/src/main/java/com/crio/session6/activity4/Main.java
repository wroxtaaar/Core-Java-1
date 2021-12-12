package com.crio.session6.activity4;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        method1();
        System.out.println("After Calling method1()");
    }
    public static void method1() throws FileNotFoundException{
        method2();
    }
    public static void method2() throws FileNotFoundException{
        method3();
    }

    public static void method3() throws FileNotFoundException{
        throw new FileNotFoundException();
    }
}
