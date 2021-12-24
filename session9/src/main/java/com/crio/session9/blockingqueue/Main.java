package com.crio.session9.blockingqueue;

public class Main {
    public static void main(String[] args) {
        SimpleBlockingQueue simpleBlockingQueue = new SimpleBlockingQueue();
        // Creating producer and consumer threads
        Thread producer = new Thread(new Producer(simpleBlockingQueue));
        Thread consumer = new Thread(new Consumer(simpleBlockingQueue)); 
 
        producer.start();
        consumer.start();
    }
}
