package com.crio.session9.blockingqueue;

public class SimpleBlockingQueue {
    final Object[] items = new Object[100]; 
    int putptr, takeptr, count;
    private boolean closed = false;

    public synchronized void put(Object x) throws InterruptedException {
        while (count == items.length)
            wait(); 
        items[putptr] = x;
        System.out.println("Producing - " + x);
        if (++putptr == items.length) putptr = 0;
        ++count;
        notifyAll();    
    }

    public synchronized Object take() throws InterruptedException {
        while (count == 0)
            wait(); 
        Object x = items[takeptr];
        System.out.println("Consuming - " + x);
        if (++takeptr == items.length) takeptr = 0;
        --count;
        notifyAll();    
        return x;
    }

    public synchronized boolean isClosed() {
        return closed;
    }

    public synchronized void setClosed(boolean closed) {
        this.closed = closed;
    }
}
