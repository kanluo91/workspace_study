package com.example.myapp.thread;

import android.util.Log;

import com.example.myapp.service.StringUtils;

public class MyThread extends Thread{

    public MyThread() {
        Log.i(StringUtils.threadTag,"创建了自定义线程");
    }

    @Override
    public void run() {
        for (int i = 0;i<10;i++){
            Log.i(StringUtils.threadTag,"我是子线程");
        }
    }
}
