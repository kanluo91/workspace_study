package com.example.myapp.broadcast;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.myapp.service.StringUtils;

public class SortedReceiver03 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if(action != null && action.equals(MyReceiver.myaction)){
            String resultData = getResultData();
            String passResult = "内容被3修改" + resultData;
            Log.i(StringUtils.logTag,"接收有序广播3 = " + resultData);
            setResultData(passResult);
        }
    }
}
