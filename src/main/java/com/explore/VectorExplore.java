package com.explore;

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by kevin on 18-1-14.
 */
public class VectorExplore {
    public static void main(String[] args) {
        BaseExplore();
    }

    /**
     * Base operation explore of Vector
     */
    private static void  BaseExplore(){
        //crate
        Vector v = new Vector();

        //Vector v1 = new Vector(10,10); //设置初始化容量和扩容系数

        //add element
        v.add("1");
        v.add("2");
        v.add("3");
        v.add("4");
        v.add("5");

        System.out.println("init: " + v);

        //set
        v.set(2,"100");
        System.out.println("update value of index 2 :" + v);

        //add
        v.add("200");
        System.out.println("add new element:" + v);

        //get index of element
        System.out.println("indexOf:" + v.indexOf("100"));
        System.out.println("lastIndexOf:" + v.lastIndexOf("200"));

        //get element of index
        System.out.println("elementAt:" + v.elementAt(2));

        //get size of Vector
        System.out.println("size:" + v.size());

        //get capacity of Vector
        System.out.println("Capacity:" + v.capacity());

        //sub list element of Vector
        System.out.println("sub 2 to 4:" + v.subList(2, 4));

        //Through get() traversal Vector.
        Integer value = null;
//        for (int i = 0; i < v.size(); i++) {
//            value = (Integer)v.get(i);
//        }

        //Through iterator traversal Vector
        Iterator i = v.iterator();
        while (i.hasNext()){
            System.out.println("Through iterator traversal Vector:" + i.next());
        }
    }
}
