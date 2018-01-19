package com.explore.Thread;

import com.explore.Thread.Entity.ProductEntityStyleOne;

/**
 * Created by Administrator on 2018/1/17.
 */
public class CustomerStyleOne implements Runnable {
    private ProductEntityStyleOne produce;
    private Object lock;
    public CustomerStyleOne(ProductEntityStyleOne productLst, Object lock){
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
                if(produce.ls.size() <= 0){
                    System.out.println("线程" + Thread.currentThread().getName() + " 产品脱销进入等待(wait)！");
                    try {
                        lock.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }

                System.out.println("线程 " + Thread.currentThread().getName() + "消费：" + produce.ls.poll() + "    余量:" + produce.ls.size());
                if(produce.ls.size() == 0){
                    System.out.println("线程 " + Thread.currentThread().getName() + "： 产品脱销，将唤起生产者！");
                    lock.notifyAll();
                    System.out.println("线程 " + Thread.currentThread().getName() + "： 生产者已经唤起！");
                }
            }
        }
    }
}
