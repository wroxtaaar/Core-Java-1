package com.crio.session8.activity1;

public class StaticCounterIncrementor extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            StaticCounter.increment();
        }
    }
}
