package com.explore.Thread.Entity;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by SuperZhangx on 2018/1/17.
 */
public class ProductEntityStyleOne {
    public  final AtomicInteger productId = new AtomicInteger(0);
    public final LinkedList<String>  ls = new LinkedList();
}
