package com.explore.threadpool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by SuperZhangx on 2018/1/24.
 */
public class ThreadPoolExecutorExplore {
    public static void main(String[] args) {
        ThreadPoolExecutorExplore threadMain = new ThreadPoolExecutorExplore();
        //rejectedExcutorHandlerImpl
        RejectedExcutorHandlerImpl r = threadMain.new RejectedExcutorHandlerImpl();
        //create ThreadPoolExecutor
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2,4,10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2), r);
        //create MonitorThread
        MonitorThread monitorThread = threadMain.new MonitorThread(threadPool, 3);
        ExecutorService singleThread = Executors.newSingleThreadExecutor();
        singleThread.submit(monitorThread);

        long startTime = System.currentTimeMillis();
        AtomicLong counter = new AtomicLong(0);
        for (int i = 0; i < 100; i++) {
            WorkerThread workThread = threadMain.new WorkerThread(startTime, counter);
            threadPool.execute(workThread);
        }

        try {
            Thread.sleep(30000);
            threadPool.shutdownNow();

            Thread.sleep(5000);
            monitorThread.shutdown();
        }catch (InterruptedException e) {

        }
    }

    class RejectedExcutorHandlerImpl implements RejectedExecutionHandler{
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println(Thread.currentThread().getName() + " is rejected!");
        }
    }

    class WorkerThread implements Runnable{
        private long startTime,endTime;
        private AtomicLong excutorCounter;
        public WorkerThread(long time, AtomicLong counter){
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

    class MonitorThread implements Runnable{
        private ThreadPoolExecutor executor;
        private long delaySeconds;
        private boolean run=true;
        public MonitorThread(ThreadPoolExecutor executor, long delay){
            this.executor = executor;
            this.delaySeconds = delay;
        }

        public void shutdown(){
            this.run=false;
        }

        @Override
        public void run() {
            while(run){
                System.out.println(
                        String.format("[monitor] [%d/%d] Active: %d, Completed: %d, Task: %d, isShutdown: %s, isTerminated: %s",
                                this.executor.getPoolSize(),
                                this.executor.getCorePoolSize(),
                                this.executor.getActiveCount(),
                                this.executor.getCompletedTaskCount(),
                                this.executor.getTaskCount(),
                                this.executor.isShutdown(),
                                this.executor.isTerminated()));
                try {
                    Thread.sleep(delaySeconds*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
