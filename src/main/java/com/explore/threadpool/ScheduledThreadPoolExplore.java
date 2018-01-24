package com.explore.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Administrator on 2018/1/23.
 */
public class ScheduledThreadPoolExplore {
    public static void main(String[] args) {
        //TestTimingTaskForScheduledThreadPool();
        int ssize = 3;
        System.out.println(1 << 16);
    }

    /**
     * create test
     */
    private static void TestScheduledThreadPool(){
        ScheduledExecutorService theadPool = Executors.newScheduledThreadPool(5);
        long startTime;
        startTime = System.currentTimeMillis();
        ScheduledThreadPoolExplore a = new ScheduledThreadPoolExplore();
        ScheduledThreadPoolExplore.CallableThread t = a.new CallableThread(startTime);
        theadPool.schedule(t,5, TimeUnit.SECONDS);
    }


    /**
     * create timing task
     */
    private static void TestTimingTaskForScheduledThreadPool(){
        ScheduledExecutorService theadPool = Executors.newScheduledThreadPool(5);
        long startTime;
        startTime = System.currentTimeMillis();
        AtomicLong l = new AtomicLong(0);
        ScheduledThreadPoolExplore a = new ScheduledThreadPoolExplore();
        ScheduledThreadPoolExplore.RunnableThread t = a.new RunnableThread(startTime, l);
        theadPool.scheduleAtFixedRate(t, 0, 3, TimeUnit.SECONDS);
    }

    class RunnableThread implements Runnable{
        private long startTime,endTime;
        private AtomicLong excutorCounter;
        public RunnableThread(long time, AtomicLong counter){
            startTime = time;
            endTime = time;
            excutorCounter = counter;
        }

        @Override
        public void run() {
            endTime = System.currentTimeMillis();
            excutorCounter.incrementAndGet();
            System.out.println("线程" + Thread.currentThread().getName() + "在" + ((endTime - startTime)/1000) + "s,执行第    " + excutorCounter + "次");
        }
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
