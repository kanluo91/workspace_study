package com.example.myapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'myapp' library on application startup.
    static {
        System.loadLibrary("myapp");
    }

    private ActivityMainBinding binding;

    private  TextView tv_showResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        tv_showResult = binding.sampleText;
        tv_showResult.setText(stringFromJNI());

        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                intent.putExtra("name","kkluo");
                startActivity(intent);
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