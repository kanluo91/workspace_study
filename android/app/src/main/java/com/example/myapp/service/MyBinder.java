package com.example.myapp.service;

import android.os.Binder;
import android.util.Log;

public class MyBinder extends Binder {

    // 构造
    public MyBinder(){
        Log.i(StringUtils.logTag,"MyBinder的构造方法调用了");
    }

    public MyService getServiceBinder(){
        return new MyService();
    }

}
