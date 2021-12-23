package com.crio.session8.activity1;

public class StaticCounter {
    private static int count = 0;

    public static void increment() {
        count++;
    }

    public static void decrement() {
        count--;
    }

    //Method Level Synchronization
    // public static synchronized void increment() {
    //     count++;
    // }

    // public static synchronized void decrement() {
    //     count--;
    // }

    // Block level Synchronization
    // public static void increment() {
    //    synchronized (StaticCounter.class) {
    //     count++;
    //    } 
    // }

    // public static void decrement() {
    //    synchronized (StaticCounter.class) {
    //     count--;
    //    }
    // }

    public static int getCount() {
        return count;
    } 
}
