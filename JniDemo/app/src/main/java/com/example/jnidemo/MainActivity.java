package com.example.jnidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jnidemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'jnidemo' library on application startup.
    static {
        Log.i("JNI","加载SO库");
        System.loadLibrary("jnidemo");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(stringFromJNI());

        Button jniBtn = findViewById(R.id.button);
        jniBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int c = jniadd(10,20);
                String v = Integer.toString(c);
                Log.i("JNI","调用了Jni的函数" + v);
            }
        });
    }

    /**
     * A native method that is implemented by the 'jnidemo' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    public native int jniadd(int a,int b);

    public native boolean checkUserNameAndPwd(String username,String pwd);


}