package com.explore;

import java.util.*;

/**
 * Created by SuperZhangx on 2018/1/12.
 *
 * <p>ArrayList Describe</p>
 * An array of automatic expansion, equivalent to a dynamic array.(Default Capacity: 10)
 */
public class ArrayListExplore {
    public static void main(String[] args) {
        //EfficiencyTest();
        ArrayListIteratorTest();
        ArrayListGetTest();
        ArrayListForeachTest();
    }

    /**
     * The effect of capacity on efficiency.
     *
     */
    private static void EfficiencyTest(){
        ArrayList<Integer> first = new ArrayList<Integer>();
        ArrayList<Integer> second = new ArrayList<Integer>(1000);

        long startTime,endTime;
        startTime = System.currentTimeMillis();
        for (int i=0; i<100000; i++){
            first.add(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("First ArrayList Interval:" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i=0; i<100000; i++){
            second.add(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Second ArrayList Interval:" + (endTime - startTime));
    }

    /**
     * ArrayList iterator test
     */
    private static void ArrayListIteratorTest(){
        long startTime,endTime;
        ArrayList<Integer> ls = new ArrayList<Integer>();
        for (int i=0; i<100000; i++){
            ls.add(i);
        }

        Integer value = null;
        Iterator iter = ls.iterator();
        startTime = System.currentTimeMillis();
        while (iter.hasNext()){
            value = (Integer)iter.next();
        }
        endTime = System.currentTimeMillis();
        System.out.println("ArrayList iterator 100000 interval:" + (endTime - startTime));
    }

    /**
     * ArrayList for test
     */
    private static void ArrayListGetTest(){
        long startTime,endTime;
        ArrayList<Integer> ls = new ArrayList<Integer>();
        for (int i=0; i<100000; i++){
            ls.add(i);
        }

        Integer value = null;
        startTime = System.currentTimeMillis();
        for (int i=0; i<ls.size(); i++){
            value = ls.get(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("ArrayList for 100000 interval:" + (endTime - startTime));
    }


    /**
     * ArrayList foreach test
     */
    private static void ArrayListForeachTest(){
        long startTime,endTime;
        ArrayList<Integer> ls = new ArrayList<Integer>();
        for (int i=0; i<100000; i++){
            ls.add(i);
        }

        Integer value = null;
        startTime = System.currentTimeMillis();
        for (Integer e:ls){
            value = e;
        }
        endTime = System.currentTimeMillis();
        System.out.println("ArrayList foreach 100000 interval:" + (endTime - startTime));
    }
}

