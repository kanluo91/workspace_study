package com.example.myapp.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.myapp.LoginActivity;
import com.example.myapp.MainActivity;
import com.example.myapp.service.StringUtils;

public class MyReceiver extends BroadcastReceiver {
    public static String myaction = "myaction";
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null && action.equals(myaction)) {
            String username = intent.getStringExtra("username");
            String pwd = intent.getStringExtra("pwd");
            Log.i(StringUtils.logTag, "广播" + "username = " + username + "\n" + "pwd =" + pwd);
//            Intent intent1 = new Intent(context,LoginActivity.class);
//            context.startActivity(intent1);
        }
    }
}
