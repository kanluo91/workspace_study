package com.example.myapp.broadcast;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.myapp.service.StringUtils;

public class SortedReceiver01 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if(action != null && action.equals(MyReceiver.myaction)){
            String resultData = intent.getStringExtra("data");
            String passResult = "内容被1修改:" + resultData;
            Log.i(StringUtils.logTag,"接收有序广播1 = " + resultData);
            setResultData(passResult);
        }
    }
}
