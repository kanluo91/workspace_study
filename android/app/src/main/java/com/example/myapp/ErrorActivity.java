package com.example.myapp;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapp.exception.MyCustionException;
import com.example.myapp.service.StringUtils;

public class ErrorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_error);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        democase1();

        try {
            int result= democase2(10,3);
            Log.i(StringUtils.logTag,"democase2计算结果" + result);
            int result2= democase2(10,0);
        } catch (Exception e) {
            Log.i(StringUtils.logTag,e.getMessage());
        }
    }

    private int democase2(int a,int b) throws Exception{
        if(b == 0){
            MyCustionException exception = new MyCustionException("除数不能为0");
            throw exception;
        }
        return a/b;
    }

    public void democase1(){

        try {
            int value1 = Integer.parseInt("1232312123sadasd");
        }catch (Exception ee){
            ee.printStackTrace();
        }finally {

        }


    }
}