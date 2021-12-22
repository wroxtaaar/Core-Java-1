package com.crio.session7.activity1;

public class ThreadLifeCycle implements Runnable{



 public static Thread thread1;
 public static ThreadLifeCycle threadLifeCycle;

 public static void main(String[] args) {

  threadLifeCycle = new ThreadLifeCycle();
  thread1 = new Thread(threadLifeCycle);

  // thread1 created and is currently in the NEW state.
  System.out.println("State of thread1 after creating it - " + thread1.getState());
  thread1.start();

  // thread1 moved to Runnable state
  System.out.println("State of thread1 after calling start() method on it - " + thread1.getState());

 }

 @Override
 public void run() {
  CustomThread customThread = new CustomThread();
  Thread thread2 = new Thread(customThread);

  // thread1 created and is currently in the NEW state.
  System.out.println("State of thread2 after creating it - " + thread2.getState());
  thread2.start();

  // thread2 moved to Runnable state
  System.out.println("State of thread2 after calling start() method on it - " + thread2.getState());

  // moving thread1 to timed waiting state
  try {
   // moving thread1 to timed waiting state
   Thread.sleep(200);
  } catch (InterruptedException e) {
   e.printStackTrace();
  }
  System.out.println("State of thread2 after calling sleep() method on it - " + thread2.getState());

  try {
   // waiting for thread2 to die / complete it's execution
   thread2.join();
  } catch (InterruptedException e) {
   e.printStackTrace();
  }
  System.out.println("State of thread2 when it has finished it's execution - " + thread2.getState());
 }

}
