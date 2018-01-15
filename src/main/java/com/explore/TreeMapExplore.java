package com.explore;

import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;

/**
 * Created by SuperZhangx on 2018/1/15.
 */
public class TreeMapExplore {
    public static void main(String[] args) {
        TreeMapApiExplore();
    }

    private static void TreeMapApiExplore(){
        TreeMap treemap = new TreeMap();
        Random r = new Random();

        treemap.put(1, r.nextInt(10));
        treemap.put(2, r.nextInt(10));
        treemap.put(3, r.nextInt(10));
        treemap.put(4, r.nextInt(10));
        treemap.put(5, r.nextInt(10));

        System.out.printf("%s\n", treemap);

        NavigableMap a = treemap.descendingMap();

        System.out.printf("%s\n", a);
    }
}
