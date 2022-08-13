package com.guetunknow.imagewall.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.guetunknow.imagewall.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //按钮监听，public void onClick(View view)实现
        findViewById(R.id.btnRegister1).setOnClickListener(this);
        findViewById(R.id.btnLogin).setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnRegister1:
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                break;
            case R.id.btnLogin:
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
//                intent.putExtras(intent);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}