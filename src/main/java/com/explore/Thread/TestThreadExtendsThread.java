package com.explore.Thread;

/**
 * Created by Administrator on 2018/1/17.
 */
public class TestThreadExtendsThread extends Thread {
    private void ThreadBaseTest(){
        for (int i = 0; i < 100; i++) {
            System.out.println("TestThreadExtendsThread println:" + i);
        }
    }

    @Override
    public void run() {
        this.ThreadBaseTest();
    }
}
