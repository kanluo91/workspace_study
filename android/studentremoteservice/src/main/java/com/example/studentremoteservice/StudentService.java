package com.example.studentremoteservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class StudentService extends Service{
    public StudentService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return new StudentBinder();
    }

}