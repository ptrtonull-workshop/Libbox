package com.guoyachen.smart_home_center_box;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Login(View view) {

            //这里需要完成一个登录验证

        //登录验证不成功，则弹出悬浮窗提示。



        //登录成功则显示登录成功，延时1秒跳转
        Intent intent  = new Intent(getApplicationContext(),Main_Navigate_Activity.class);
        Toast toast = Toast.makeText(this,R.string.login_correct,Toast.LENGTH_SHORT);
        toast.show();

        startActivity(intent);
    }
}
