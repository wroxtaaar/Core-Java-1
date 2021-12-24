package com.crio.session9.blockingqueue;

public class Producer implements Runnable{
    private SimpleBlockingQueue simpleBlockingQueue;
 
    public Producer(SimpleBlockingQueue simpleBlockingQueue){
        this.simpleBlockingQueue = simpleBlockingQueue;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                simpleBlockingQueue.put(i);                            
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
