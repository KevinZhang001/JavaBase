package com.explore.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/1/23.
 */
public class ScheduledThreadPoolExplore {
    public static void main(String[] args) {
        TestScheduledThreadPool();
    }

    private static void TestScheduledThreadPool(){
        ScheduledExecutorService theadPool = Executors.newScheduledThreadPool(5);
        long startTime;
        startTime = System.currentTimeMillis();
        ScheduledThreadPoolExplore a = new ScheduledThreadPoolExplore();
        ScheduledThreadPoolExplore.CallableThread t = a.new CallableThread(startTime);
        theadPool.schedule(t,5, TimeUnit.SECONDS);
    }

    class CallableThread implements Callable {
        private long startTime,endTime;
        public CallableThread(long time){
            startTime = time;
            endTime = time;
        }

        @Override
        public Object call() throws Exception {
            endTime = System.currentTimeMillis();
            System.out.println("线程已经执行！执行延迟时间（ms）：" + (endTime - startTime));
            return "线程已执行";
        }
    }
}
