package com.guetunknow.imagewall.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


import com.guetunknow.imagewall.Bean.User;
import com.guetunknow.imagewall.DAO.UserDao;
import com.guetunknow.imagewall.DataBaseHelper.MySQLUtils;
import com.guetunknow.imagewall.R;
import com.mysql.jdbc.Connection;


public class RegisterActivity extends AppCompatActivity {
    private static final String TAG = "MySQLUtils";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //
        findViewById(R.id.btnRegister).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                测试注册
                 */
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        User lihei = new User(
                                "qwer123@qq.com","lihei","pwd123456789");
                        new UserDao().add(lihei);
                    }
                }).start();

                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
    }
}