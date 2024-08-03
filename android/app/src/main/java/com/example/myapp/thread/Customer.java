package com.example.myapp.thread;

public class Customer implements Runnable{

    private SuperMarket superMarket;

    public Customer(SuperMarket superMarket){
        this.superMarket = superMarket;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

            superMarket.saleGoods();
        }
    }
}
