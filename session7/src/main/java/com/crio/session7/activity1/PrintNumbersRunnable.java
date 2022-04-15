package com.crio.session7.activity1;

import java.util.stream.IntStream;

public class PrintNumbersRunnable implements Runnable {

    @Override
    public void run() {
   
     IntStream.range(1, 11).forEach(n -> System.out.println(Thread.currentThread().getName() + " - " + n));
   
    }
}
