package com.example.myapp.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;


public class MyService extends Service {

    private MyBinder myBinder = new MyBinder();

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(StringUtils.logTag,"[onCreate]");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(StringUtils.logTag,"[onDestroy]");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String threadName = Thread.currentThread().getName();
        Log.i(StringUtils.logTag,"[onStartCommand]当前线程" + Thread.currentThread());
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.i(StringUtils.logTag,"[onBind]");
        return myBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(StringUtils.logTag,"[onUnbind]");
        return super.onUnbind(intent);
    }
}