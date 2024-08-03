package com.example.myapp.thread;

import android.util.Log;

import com.example.myapp.service.StringUtils;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        Log.i(StringUtils.threadTag,"调用MyRunnable的run方法");
    }
}
