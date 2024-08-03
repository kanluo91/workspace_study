package com.example.myapp.thread;

public class Producer implements Runnable{

    private SuperMarket superMarket;
    public Producer(SuperMarket superMarket) {
        this.superMarket = superMarket;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

            this.superMarket.importGoods();
        }
    }
}


