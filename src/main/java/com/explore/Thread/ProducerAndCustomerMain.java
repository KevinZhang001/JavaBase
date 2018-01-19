package com.explore.Thread;

import com.explore.Thread.Entity.ProductEntityStyleTwo;

/**
 * Created by SuperZhangx on 2018/1/18.
 */
public class ProducerAndCustomerMain {
    public static void main(String[] args) {
        ProducerAndCustomerMain pMain = new ProducerAndCustomerMain();
        ProductEntityStyleTwo produt = new ProductEntityStyleTwo();
        Thread p;
        p = pMain.new Producer(produt);
        p.setName("Producer Thread One");
        p.start();

        p = pMain.new Producer(produt);
        p.setName("Producer Thread Two");
        p.start();

        p = pMain.new Customer(produt);
        p.setName("Customer Thread One");
        p.start();

        p = pMain.new Customer(produt);
        p.setName("Customer Thread Two");
        p.start();
    }

    class Producer extends Thread
    {
        ProductEntityStyleTwo product;
        public Producer(ProductEntityStyleTwo p){
            this.product = p;
        }

        @Override
        public void run() {
            while (true) {
                if (product.getSize() > 100) {
                    try {
                        Thread.sleep(10);
                    }catch (InterruptedException e){e.printStackTrace();}
                }
                product.producerProduct();
                System.out.println("Thread " + Thread.currentThread().getName());
            }
        }
    }

    class Customer extends Thread
    {
        ProductEntityStyleTwo product;
        public Customer(ProductEntityStyleTwo p){
            this.product = p;
        }

        @Override
        public void run() {
            while (true) {
                if (product.getSize() <= 0) {
                    try {
                        Thread.sleep(10);
                    }catch (InterruptedException e){e.printStackTrace();}
                }
                System.out.println("Thread " + Thread.currentThread().getName() + ": customer--" + product.customerProduct());
            }
        }
    }
}
