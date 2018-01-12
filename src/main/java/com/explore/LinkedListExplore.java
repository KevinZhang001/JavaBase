package com.explore;

import java.util.LinkedList;
import java.util.Objects;

/**
 * Created by SuperZhangx on 2018/1/12.
 */
public class LinkedListExplore {
    public static void main(String[] args) {
        LinkedListIteratorTest(getLinkedList());
    }

    private static LinkedList getLinkedList(){
        LinkedList lls = new LinkedList();
        lls.push(1);
        lls.push(2);
        lls.push(3);
        lls.push(4);
        lls.push(4);
        return lls;
    }

    /**
     * Test the deque feature of LinkedList
     * LIFO
     */
    private static void LinkedListDequeLIFOTest(LinkedList lls){
        System.out.println("stack: " + lls);

        while (lls.peek() != null){
            System.out.println(lls.pop());
        }
    }

    /**
     * Test the deque feature of LinkedList
     * FIFO
     */
    private static void LinkedListDequeFIFOTest(LinkedList lls){
        System.out.println("stack: " + lls);
        while (lls.peek() != null){
            System.out.println(lls.pollLast());
        }
        System.out.println("stack: " + lls);
    }

    /**
     * Iterator test
     */
    private static void LinkedListIteratorTest(LinkedList lls){
        //First
        for (Object item:lls){
            System.out.println(item);
        }

        //Second
        while (lls.peekFirst() != null){
            //System.out.println(lls.removeFirst());
            System.out.println(lls.pop());
        }

        System.out.println(lls);
    }
}
