package com.crio.session9.blockingqueue;

public class Consumer implements Runnable{
    private SimpleBlockingQueue simpleBlockingQueue;
 
    public Consumer(SimpleBlockingQueue simpleBlockingQueue){
        this.simpleBlockingQueue = simpleBlockingQueue;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                simpleBlockingQueue.take();               
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }  
}
