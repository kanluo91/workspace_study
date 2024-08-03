package com.example.myapp.thread;

import android.util.Log;

import com.example.myapp.service.StringUtils;

public class SuperMarket {

    private final int maxGoodsCnt = 10; // 货物容量
    private volatile int currentGoodsCnt = 0; //当前货物的数量

    /// 进货
    public synchronized void importGoods(){
        if(currentGoodsCnt < maxGoodsCnt){
            currentGoodsCnt++;
            Log.i(StringUtils.threadTag,"[生产者]-----[剩余]"+currentGoodsCnt+ "[线程明]" + Thread.currentThread().getName());

            notify();
        }else{
            try {
                wait(); // 获取满了要等待
            } catch (InterruptedException e) {

            }
        }
    }

    /// 卖货
    public void saleGoods(){
        if(currentGoodsCnt > 0){
            currentGoodsCnt--;
            Log.i(StringUtils.threadTag,"   [消费者]-----[剩余]"+currentGoodsCnt + "[线程明]" + Thread.currentThread().getName());
            notify();
        }else{
            try {
                wait(); // 没有获取了，需要等待
            } catch (InterruptedException e) {
            }
        }
    }


}
