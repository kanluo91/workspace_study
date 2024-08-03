package com.example.myapp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.TimeUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapp.service.StringUtils;
import com.example.myapp.thread.Customer;
import com.example.myapp.thread.MyRunnable;
import com.example.myapp.thread.MyThread;
import com.example.myapp.thread.Producer;
import com.example.myapp.thread.SuperMarket;
import com.example.myapp.thread.TestHandlerThread;

import java.util.concurrent.TimeUnit;

public class TheadActivity extends AppCompatActivity {

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_thead);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        demo_thread1();
        demo_thread2();
//        demo_thread3();/// 生产-消费者


//        try {
//            TimeUnit.SECONDS.sleep(1);
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        demo_handler();
    }

    private void demo_handler() {

        TextView tv_showhandler = findViewById(R.id.tv_showhandler);

        /// 创建Handler,会和当前线程的Loop关联
        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message msg) {
                Log.i(StringUtils.threadTag,"[Handle 回调]" + msg);
                if(msg.what == 99){
                    tv_showhandler.setText(msg.obj.toString());
                }
                return true;
            }
        });


        Button btn = findViewById(R.id.handlebtn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestHandlerThread testHandlerThread = new TestHandlerThread(handler);
                testHandlerThread.start();
            }
        });
    }

    private void demo_thread3() {

        SuperMarket superMarket = new SuperMarket();
        Producer producer = new Producer(superMarket);
        Customer customer = new Customer(superMarket);

        Thread[] pThreads = new Thread[6];
        for(int i = 0;i<pThreads.length;i++){
            pThreads[i] = new Thread(producer);
            pThreads[i].setName("生产者"+i+"号");
            pThreads[i].start();
        }

        Thread[] cThreads = new Thread[3];
        for(int i = 0;i<cThreads.length;i++){
            cThreads[i] = new Thread(customer);
            cThreads[i].setName("消费者"+i+"号");
            cThreads[i].start();
        }

    }

    private void demo_thread2() {
        MyRunnable rt = new MyRunnable();
        Thread thread = new Thread(rt);
        thread.start();
    }

    private void demo_thread1() {
        MyThread mt = new MyThread();
        mt.start();
    }


}