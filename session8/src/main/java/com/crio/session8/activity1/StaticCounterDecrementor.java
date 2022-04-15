package com.crio.session8.activity1;

public class StaticCounterDecrementor extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            StaticCounter.decrement();
        }
    }
}
