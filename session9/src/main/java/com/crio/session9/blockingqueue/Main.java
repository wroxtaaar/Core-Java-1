package com.crio.session9.blockingqueue;

public class Main {
    public static void main(String[] args) {
        SimpleBlockingQueue simpleBlockingQueue = new SimpleBlockingQueue(4);
        // Creating producer and consumer threads
        Thread producer = new Thread(new Producer(simpleBlockingQueue),"Producer 1");
        Thread consumer = new Thread(new Consumer(simpleBlockingQueue),"Consumer 1"); 
 
        producer.start();
        consumer.start();
    }
}
