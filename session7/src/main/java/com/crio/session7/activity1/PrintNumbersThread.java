package com.crio.session7.activity1;

import java.util.stream.IntStream;

public class PrintNumbersThread extends Thread {

    @Override
    public void run() {
   
     IntStream.range(1, 11).forEach(n -> System.out.println(Thread.currentThread().getName() + " - " + n));
   
    }
}
