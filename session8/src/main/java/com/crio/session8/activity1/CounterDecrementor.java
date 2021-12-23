package com.crio.session8.activity1;

public class CounterDecrementor extends Thread {
    private Counter counter;

    public CounterDecrementor(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            counter.decrement();
        }
    }
}
