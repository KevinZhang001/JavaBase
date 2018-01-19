package com.explore.Thread.Entity;

import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by SuperZhangx on 2018/1/19.
 * production and consumption of use ReentrantReadWriteLock(可重入读写锁)
 */
public class ProductEntityStyleThree {
    private int productId = 0;
    private final LinkedList<Integer> productLs = new LinkedList();
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();

    public void producerProduct(){
        w.lock();
        try {
            productLs.push(productId++);
        }finally {
            w.unlock();
        }
    }

    public Integer customerProduct(){
        r.lock();
        try {
            return productLs.pollLast();
        }finally {
            r.unlock();
        }
    }

    public Integer getSize(){
        r.lock();
        try {
            return productLs.size();
        }finally {
            r.unlock();
        }
    }
}
