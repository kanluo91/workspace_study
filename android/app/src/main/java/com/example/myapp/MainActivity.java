package com.example.myapp;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapp.databinding.ActivityMainBinding;
import com.example.myapp.service.MyBinder;
import com.example.myapp.service.MyService;
import com.example.myapp.service.StringUtils;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'myapp' library on application startup.
    static {
        System.loadLibrary("myapp");
    }

    private String logTag = "TTTTTTTT";

    private ActivityMainBinding binding;

    private  TextView tv_showResult;

    private  MyBinder myBinder;

    private ServiceConnection serviceConnection;
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int vid = v.getId();
            if(vid == R.id.btn3){   // start service
                Log.i(StringUtils.logTag,"点击了按钮" + "start service");
                Intent intent = new Intent(MainActivity.this,MyService.class);
                startService(intent);
            }else if(vid == R.id.btn4){ // stop service
                Log.i(StringUtils.logTag,"点击了按钮" + "stop service");
                Intent intent = new Intent(MainActivity.this,MyService.class);
                stopService(intent);
            }else if(vid == R.id.btn5){ // bind service
                Log.i(StringUtils.logTag,"点击了按钮" + "bind service");

                Intent intent = new Intent(MainActivity.this,MyService.class);
                serviceConnection = new ServiceConnection() {
                    @Override
                    public void onServiceConnected(ComponentName name, IBinder service) {
                        Log.i(StringUtils.logTag,"[ServiceConnection]-[onServiceConnected]");
                        if(service instanceof MyBinder){
                            myBinder = (MyBinder) service;
                            Log.i(StringUtils.logTag,"[ServiceConnection]-[service是MyBinder]");
                        }
                    }

                    @Override
                    public void onServiceDisconnected(ComponentName name) {
                        Log.i(StringUtils.logTag,"[ServiceConnection]-[onServiceDisconnected]");

                    }
                };
                bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);

            }else if(vid == R.id.btn6){ // unbind service
                Log.i(StringUtils.logTag,"点击了按钮" + "unbind service");
                unbindService(serviceConnection);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        tv_showResult = binding.sampleText;
        tv_showResult.setText(stringFromJNI());


        demo_activity();
        demo_Service();

    }

    private void demo_activity(){
        ActivityResultLauncher launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult o) {

                String params = "回调" + String.valueOf(o.getData().getIntExtra("age",-1));
                tv_showResult.setText(params);
            }
        });

        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                intent.putExtra("name","kkluo");
                launcher.launch(intent);

            }
        });

        Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                intent.putExtra("name","金角大王");
                startActivityForResult(intent,1);
                setResult(1,intent);
            }
        });
    }

    private void demo_Service(){
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        btn3.setOnClickListener(listener);
        btn4.setOnClickListener(listener);
        btn5.setOnClickListener(listener);
        btn6.setOnClickListener(listener);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("跳转","页面回调" + data.getIntExtra("age",-1));
        String params = "回调" + String.valueOf(data.getIntExtra("age",-1));
        tv_showResult.setText(params);
    }

    /**
     * A native method that is implemented by the 'myapp' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}