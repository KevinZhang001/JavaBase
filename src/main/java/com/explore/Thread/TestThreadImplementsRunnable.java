package com.explore.Thread;

/**
 * Created by SuperZhangx on 2018/1/17.
 */
public class TestThreadImplementsRunnable implements Runnable {
    private void ThreadBaseTest(){
        for (int i = 0; i < 100; i++) {
            System.out.println("println:" + i);
        }
    }

    @Override
    public void run() {
        this.ThreadBaseTest();
    }
}
