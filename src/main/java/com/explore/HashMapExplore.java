package com.explore;

import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry;

import java.util.*;

/**
 * Created by superzhangx on 2018/1/15.
 */
public class HashMapExplore {
    public static void main(String[] args) {
        //HashMapHashTest();
        HashMapApiExplore();
        LinkedHashMapExplore();
    }

    private static void HashMapApiExplore(){
        Random r = new Random();
        HashMap map = new HashMap();
        map.put("a", r.nextInt(100));
        map.put("b", r.nextInt(100));
        map.put("c", r.nextInt(100));
        map.put("d", r.nextInt(100));

        System.out.println("init map:" + map);

        //Iterator
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry entry = (Map.Entry)it.next();
            System.out.println("Key:" + entry.getKey() + "  value:" + entry.getValue());
        }

        //clear()
        map.clear();
        System.out.println(map);
    }

    private static void HashMapHashTest(){
        HashMap map = new HashMap();
        map.put("a", 1);

        int h,index;
        h = hash("a");
        index = h & (16-1);
        System.out.println("hash:" + h);
        System.out.println("index:" + index);
    }

    final static int hash(Object k) {
        int h = 0;
        if (0 != h && k instanceof String) {
            return sun.misc.Hashing.stringHash32((String) k);
        }

        h ^= k.hashCode();
        System.out.println(h);
        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    private static void LinkedHashMapExplore(){
        Random r = new Random();
        LinkedHashMap map = new LinkedHashMap();
        map.put("a", r.nextInt(100));
        map.put("b", r.nextInt(100));
        map.put("c", r.nextInt(100));
        map.put("d", r.nextInt(100));

        System.out.println("init map:" + map);

        //Iterator
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry entry = (Map.Entry)it.next();
            System.out.println("Key:" + entry.getKey() + "  value:" + entry.getValue());
        }

        //clear()
        map.clear();
        System.out.println(map);
    }
}
