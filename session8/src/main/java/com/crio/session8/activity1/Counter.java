package com.crio.session8.activity1;

public class Counter {
    private int count = 0;

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }

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
