package com.guetunknow.imagewall.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


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
                //获取用户name
                EditText editName =(EditText)findViewById(R.id.etNama);
                String name=editName.getText().toString();
                //获取email
                EditText editEmail =(EditText)findViewById(R.id.etEmail);
                String email=editEmail.getText().toString();
                //获取密码
                EditText editPassword =(EditText)findViewById(R.id.etPassword);
                String password=editPassword.getText().toString();

                if(name.equals("") ){
                    Toast.makeText(RegisterActivity.this, "请输入昵称", Toast.LENGTH_LONG).show();
                }
                else if(email.equals("")){
                    Toast.makeText(RegisterActivity.this, "请输入邮箱", Toast.LENGTH_LONG).show();
                }
                else if(password.equals("")){
                    Toast.makeText(RegisterActivity.this, "请输入密码", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_LONG).show();

                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            User lihei = new User(email,name,password);
                            new UserDao().add(lihei);
                        }
                    }).start();

                    startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                }
                /*
                测试注册
                 */
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//
//                        User lihei = new User(
//                                "qwer123456@qq.com","lihei","pwd123456789");
//                        new UserDao().add(lihei);
//                    }
//                }).start();

                //startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
    }
}