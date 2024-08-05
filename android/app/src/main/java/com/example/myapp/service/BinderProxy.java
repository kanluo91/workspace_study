package com.example.myapp.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;

public class BinderProxy implements StudentInferface {

    private final IBinder studentBinder;

    public BinderProxy(IBinder binder){
        studentBinder = binder;
    }


    @Override
    public String queryNamebyId(String id) {
        Parcel sender = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        sender.writeString(id);
        if(studentBinder != null){
            try {
                boolean isSucc = studentBinder.transact(999,sender,reply,0);
                Log.i(StringUtils.serviceTag,"[远端服务是否成功]" + isSucc);
                if(isSucc){
                    String result = reply.readString();
                    Log.i(StringUtils.serviceTag,"[远端服务获取数据]" + result);
                    return result;
                }
            } catch (RemoteException e) {
                return "查询失败[Exception]" +e.toString();
            }
        }
        return "查询失败";
    }

    public static StudentInferface asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        if(iBinder instanceof StudentInferface){
            return (StudentInferface) iBinder;
        }
        return new BinderProxy(iBinder);
    }
}
