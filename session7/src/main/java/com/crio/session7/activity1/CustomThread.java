package com.crio.session7.activity1;

public class CustomThread implements Runnable {
    
    @Override
    public void run() {
        // moving thread2 to timed waiting state
        try {
         Thread.sleep(1500);
        } catch (InterruptedException e) {
         e.printStackTrace();
        }
      
        System.out.println(
          "State of " + ThreadLifeCycle.thread1.getName() + " while it called join() method on " + Thread.currentThread().getName() + "-" + ThreadLifeCycle.thread1.getState());
        try {
         Thread.sleep(200);
        } catch (InterruptedException e) {
         e.printStackTrace();
        }
       }
}
