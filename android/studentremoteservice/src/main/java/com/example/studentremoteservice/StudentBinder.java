package com.example.studentremoteservice;

import android.os.Binder;
import android.os.Parcel;
import android.os.RemoteException;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class StudentBinder extends Binder implements StudentInferface {

    private final int StudentHandleCode = 999;

    public StudentBinder(){
        Student student = new Student();
    }

    @Override
    protected boolean onTransact(int code, @NonNull Parcel data, @Nullable Parcel reply, int flags) throws RemoteException {
        if(code == StudentHandleCode){
            String id = data.readString();
            String name = queryNamebyId(id);
            if(reply != null){
                reply.writeString(name);
            }
            return true;
        }
        return super.onTransact(code, data, reply, flags);
    }

    @Override
    public String queryNamebyId(String id) {
        return Student.queryNamebyId(id);
    }
}
