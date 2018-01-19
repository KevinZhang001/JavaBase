package com.explore.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by SuperZhangx on 2018/1/17.
 */
public class ThreadExplore {
    public static void main(String[] args) {
        //ss.setName();
        //ss.setDaemon(); //是否为守护进程

        Executor executor = Executors.newFixedThreadPool(10);
        createThread();
    }

    /**
     * test create of thread
     */
    private static void createThread(){
        /*[ Style One ] -- implements Runnable */
//        TestThreadImplementsRunnable thread = new TestThreadImplementsRunnable();
//        Thread t = new Thread(thread);
//        t.setName("TestThreadImplementsRunnable");
//        t.start();

        /* [Style Two] -- extends Thread */
        Thread t = new TestThreadExtendsThread();
        t.setName("TestThreadExtendsThread");
        t.start();
    }
}
