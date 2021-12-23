package com.crio.session8.activity1;

public class CounterIncrementor extends Thread{
    private Counter counter;

    public CounterIncrementor(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            counter.increment();
        }
    }
}
