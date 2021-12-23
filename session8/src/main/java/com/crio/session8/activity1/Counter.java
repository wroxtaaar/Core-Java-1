package com.crio.session8.activity1;

public class Counter {
    private int count = 0;
    // Enter Critical section
    public void increment() {
        count++;
    }
    // Exit Critical section

    // Enter Critical section
    public void decrement() {
        count--;
    }
    // Exit Critical section

    // Method Level Synchronization
    // public synchronized void increment() {
    //     count++;
    // }

    // public synchronized void decrement() {
    //     count--;
    // }

    // Block level Synchronization
    // public void increment() {
    //    synchronized (this) {
    //     count++;
    //    } 
    // }

    // public void decrement() {
    //    synchronized (this) {
    //     count--;
    //    }
    // }

    public int getCount() {
        return count;
    } 
}
