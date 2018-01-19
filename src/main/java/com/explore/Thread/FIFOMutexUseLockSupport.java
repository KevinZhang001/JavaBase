package com.explore.Thread;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by SuperZhangx on 2018/1/19.
 * lock of first-in-first-out and non-reentrant --- 不可重入的先进先出锁
 */
public class FIFOMutexUseLockSupport {
    private final AtomicBoolean locked = new AtomicBoolean(false);
    private final Queue<Thread> waiters
            = new ConcurrentLinkedQueue<>();

    public void lock() {
        boolean wasInterrupted = false;
        // publish current thread for unparkers
        waiters.add(Thread.currentThread());

        // Block while not first in queue or cannot acquire lock
        while (waiters.peek() != Thread.currentThread() ||
                !locked.compareAndSet(false, true)) {
            LockSupport.park(this);
            // ignore interrupts while waiting
            if (Thread.interrupted())
                wasInterrupted = true;
        }

        waiters.remove();
        // ensure correct interrupt status on return
        if (wasInterrupted)
            Thread.currentThread().interrupt();
    }

    public void unlock() {
        locked.set(false);
        LockSupport.unpark(waiters.peek());
    }
}
