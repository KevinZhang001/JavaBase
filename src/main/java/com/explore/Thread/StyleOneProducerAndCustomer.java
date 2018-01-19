package com.explore.Thread;

import com.explore.Thread.Entity.ProductEntityStyleOne;

/**
 * Created by Administrator on 2018/1/17.
 */
public class StyleOneProducerAndCustomer {
    public static void main(String[] args) {
        Object lock = new Object();
        ProductEntityStyleOne storage = new ProductEntityStyleOne();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        CustomerStyleOne customer;
        ProdcuerStyleOne producer;
        Thread t;
        customer =  new CustomerStyleOne(storage, lock);
        t = new Thread(customer);
        t.setName("CustomerTheadOne");
        t.start();

        customer =  new CustomerStyleOne(storage, lock);
        t = new Thread(customer);
        t.setName("CustomerTheadTwo");
        t.start();


        customer =  new CustomerStyleOne(storage, lock);
        t = new Thread(customer);
        t.setName("CustomerTheadThree");
        t.start();

        producer = new ProdcuerStyleOne(storage, lock);
        t = new Thread(producer);
        t.setName("ProducerTheadOne");
        t.start();

        producer = new ProdcuerStyleOne(storage, lock);
        t = new Thread(producer);
        t.setName("ProducerTheadTwo");
        t.start();

        producer = new ProdcuerStyleOne(storage, lock);
        t = new Thread(producer);
        t.setName("ProducerTheadThree");
        t.start();

        producer = new ProdcuerStyleOne(storage, lock);
        t = new Thread(producer);
        t.setName("ProducerTheadFour");
        t.start();
    }
}
