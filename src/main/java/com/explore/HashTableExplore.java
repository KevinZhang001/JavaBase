package com.explore;

import java.util.*;

/**
 * Created by SuperZhangx on 2018/1/15.
 */
public class HashTableExplore {
    public static void main(String[] args) {
        HashTableExplore();
    }

    private static void HashTableExplore(){
        Hashtable hashtable = new Hashtable();
        Random r = new Random();
        hashtable.put("a", r.nextInt(100));
        hashtable.put("b", r.nextInt(100));
        hashtable.put("c", r.nextInt(100));
        hashtable.put("d", r.nextInt(100));

        System.out.println("init HashTable:" + hashtable);

        //Iterator
        Iterator it = hashtable.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry entry = (Map.Entry)it.next();
            System.out.println("Key:" + entry.getKey() + "  value:" + entry.getValue());
        }

        //clear()
        hashtable.clear();
        System.out.println(hashtable);
    }
}

