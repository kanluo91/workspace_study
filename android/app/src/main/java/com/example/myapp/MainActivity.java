package com.example.myapp;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapp.broadcast.MyReceiver;
import com.example.myapp.broadcast.SortedReceiver01;
import com.example.myapp.broadcast.SortedReceiver02;
import com.example.myapp.broadcast.SortedReceiver03;
import com.example.myapp.databinding.ActivityMainBinding;
import com.example.myapp.service.MyBinder;
import com.example.myapp.service.MyService;
import com.example.myapp.service.StringUtils;

import java.io.IOException;
import java.io.InputStream;

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

    private SortedReceiver01 sortedReceiver01;
    private SortedReceiver02 sortedReceiver02;
    private SortedReceiver03 sortedReceiver03;


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
            }else if(vid == R.id.btn7){ // unbind service
                Log.i(StringUtils.logTag,"点击了按钮" + "发送有序广播");
                Intent intent = new Intent(MainActivity.this, MyReceiver.class);
                intent.setAction(MyReceiver.myaction);
                intent.putExtra("username","金角大王");
                intent.putExtra("pwd","1232312");
                sendBroadcast(intent);
            }else if(vid == R.id.btn8){
                Log.i(StringUtils.logTag,"点击了按钮" + "发送无序广播");
                Intent intent = new Intent();
                intent.setAction(MyReceiver.myaction);
                intent.setPackage(getPackageName());
                intent.putExtra("data","我是原始数据");
                sendOrderedBroadcast(intent,null);
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
        demo_broadcast_receiver();
        demo_exception();
        demo_thread();
        demo_sd();
        demo_assets(); /// assets中读取图片
    }

    private void demo_assets() {

        ImageView imageView = findViewById(R.id.iv_test);
        AssetManager assetManager = getAssets();
        try {
            InputStream inputStream = assetManager.open("test.png");
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            imageView.setImageBitmap(bitmap);
            inputStream.close();
        } catch (IOException e) {

        }


    }

    private void demo_thread() {
        Button btn = findViewById(R.id.gotothread);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TheadActivity.class);
                startActivity(intent);
            }
        });
    }

    private void demo_exception() {
        Button gotoerrorBtn = findViewById(R.id.gotoerror);
        gotoerrorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ErrorActivity.class);
                startActivity(intent);
            }
        });
    }

    private void demo_sd() {
        Button gotoSD = findViewById(R.id.gotosd);
        gotoSD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,SdActivity.class);
//                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//            demo_dynamic_register_receiver();
//        }
    }

    @Override
    protected void onPause() {
        super.onPause();
//        demo_dynamic_unregister_receiver();
    }

    private void demo_dynamic_unregister_receiver() {

        unregisterReceiver(sortedReceiver01);
        unregisterReceiver(sortedReceiver02);
        unregisterReceiver(sortedReceiver03);
    }

    /// 动态注册广播
    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    private void demo_dynamic_register_receiver() {

        sortedReceiver02 = new SortedReceiver02();
        sortedReceiver03 = new SortedReceiver03();

        IntentFilter filter = new IntentFilter();
        filter.addAction(MyReceiver.myaction);

            registerReceiver(sortedReceiver01,filter, Context.RECEIVER_NOT_EXPORTED);
            registerReceiver(sortedReceiver02,filter, Context.RECEIVER_NOT_EXPORTED);
            registerReceiver(sortedReceiver03,filter, Context.RECEIVER_NOT_EXPORTED);
    }

    private void demo_broadcast_receiver() {
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        btn7.setOnClickListener(listener);
        btn8.setOnClickListener(listener);
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