package com.crio.session8.activity1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        CounterIncrementor incrementingThread = new CounterIncrementor(counter);
        CounterDecrementor decrementingThread = new CounterDecrementor(counter);

        incrementingThread.start();
        decrementingThread.start();

        incrementingThread.join();
        decrementingThread.join();

        System.out.println("Counter Total Count: " + counter.getCount());

        StaticCounterIncrementor staticIncrementingThread = new StaticCounterIncrementor();
        StaticCounterDecrementor staticDecrementingThread = new StaticCounterDecrementor();

        staticIncrementingThread.start();
        staticDecrementingThread.start();

        staticIncrementingThread.join();
        staticDecrementingThread.join();

        System.out.println("Static Counter Total Count: " + StaticCounter.getCount());

    }
}
