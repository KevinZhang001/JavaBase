package com.explore.Thread.Entity;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by SuperZhangx on 2018/1/18.
 */
public class ProductEntityStyleTwo {
    private final AtomicInteger productId = new AtomicInteger(0);
    private final ConcurrentLinkedDeque<Integer> productLs = new ConcurrentLinkedDeque();

    public void producerProduct(){
        productLs.push(productId.incrementAndGet());
    }

    public Integer customerProduct(){
        return productLs.pollLast();
    }

    public Integer getSize(){
        return productLs.size();
    }
}
