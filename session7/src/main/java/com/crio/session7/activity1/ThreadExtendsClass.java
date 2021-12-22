package com.crio.session7.activity1;

public class ThreadExtendsClass {
    public static void main(String[] args) {

        PrintNumbersThread numbers1 = new PrintNumbersThread();
        numbers1.setName("PrintNumbers Thread 1");
        numbers1.start();
      
        PrintNumbersThread numbers2 = new PrintNumbersThread();
        numbers2.setName("PrintNumbers Thread 2");
        numbers2.start();
      
       }
}
