package com.crio.session9.blockingqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class SimpleBlockingQueue {
    private int queue_size = 10;

    public SimpleBlockingQueue(int queueSize){
        this.queue_size = queueSize;
    }

    Queue<Object> queue = new LinkedList<>();
    
    public synchronized void put(Object x) throws InterruptedException {
        //simulate slow processing
        TimeUnit.SECONDS.sleep(3);
        // if the queue is full, then wait for the consumer to consume an item
        while(queue.size() == queue_size){
            System.out.println(Thread.currentThread().getName()+ ": Queue full, waiting...");
            wait();
        }
        // if the queue is not full, then add the item to the queue
        queue.add(x);
        System.out.println(Thread.currentThread().getName()+ ": Producing - " + x);
        notifyAll();
    }

    public synchronized Object take() throws InterruptedException {
        //simulate slow processing
        TimeUnit.SECONDS.sleep(1);
        // if the queue is empty, then wait for the producer to produce an item
        while(queue.size() == 0){
            System.out.println(Thread.currentThread().getName()+ ": Queue empty, waiting...");
            wait();
        }
        // if the queue is not empty, then remove the item from the queue
        Object x = queue.remove();
        System.out.println(Thread.currentThread().getName()+ ": Consuming - " + x);
        notifyAll();
        return x;
    }
}
