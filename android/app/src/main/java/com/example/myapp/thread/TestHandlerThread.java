package com.example.myapp.thread;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.myapp.service.StringUtils;

public class TestHandlerThread extends Thread{
    private Handler handler;
    private Handler mainHander;
    public  TestHandlerThread(Handler handler){
        this.handler = handler;
        this.mainHander = new Handler();
    }

    @Override
    public void run() {

        for (int i = 0;i<5;i++){
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
            }
            Message message = handler.obtainMessage();
            message.what = 99;
            message.obj = "更新UI[角标] =" + i;
            handler.sendMessage(message);

            /// 主线程 更新UI
            mainHander.post(new Runnable() {
                @Override
                public void run() {
                    Log.i(StringUtils.threadTag,"[MainHandler] 当前线程" +  Thread.currentThread());
                }
            });
        }
    }
}
