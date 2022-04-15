package com.crio.session7.activity1;

public class ThreadImplementsRunnable {
    public static void main(String[] args) {

        PrintNumbersRunnable numberRunnableThread = new PrintNumbersRunnable();
      
        Thread t1 = new Thread(numberRunnableThread);
        t1.setName("Runnable Thread 1");
        t1.start();
      
        Thread t2 = new Thread(numberRunnableThread);
        t2.setName("Runnable Thread 2");
        t2.start();
      
       }
}
