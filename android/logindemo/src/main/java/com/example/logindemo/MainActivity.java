package com.example.logindemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText et_username = findViewById(R.id.et_username);
        EditText et_pwd = findViewById(R.id.et_pwd);
        Button btn_login = (Button) findViewById(R.id.bt_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = et_username.getText().toString();
                String pwd = et_pwd.getText().toString();
                if(checkUsernameAndPwd(username,pwd)){
                    Toast.makeText(MainActivity.this,"登录成功", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,"登录失败", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private boolean checkUsernameAndPwd(String username,String pwd){
        if(username == null || username.isEmpty() || pwd == null || pwd.isEmpty()){
            return false;
        }
        if(username.equals("luokan") && pwd.equals("123456")){
            return true;
        }
        return false;
    }

}