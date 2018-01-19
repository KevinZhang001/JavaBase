package com.explore.Thread;

import com.explore.Thread.Entity.ProductEntityStyleOne;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by Administrator on 2018/1/17.
 */
public class ProdcuerStyleOne implements Runnable {
    private ProductEntityStyleOne produce;
    private Object lock;
    public ProdcuerStyleOne(ProductEntityStyleOne productLst, Object lock){
        produce = productLst;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            synchronized(lock){
                if(produce.ls.size() >= 10){
                    System.out.println(Thread.currentThread().getName() + " :货架已满生产者进入等待(wait)！");
                    try {
                        lock.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                String tmp = "" + produce.productId.incrementAndGet();
                produce.ls.push(tmp);
                System.out.println(Thread.currentThread().getName() + "：生产" + produce.ls.peek() +"    余量:" + produce.ls.size());
                lock.notifyAll();
            }
        }
    }
}
