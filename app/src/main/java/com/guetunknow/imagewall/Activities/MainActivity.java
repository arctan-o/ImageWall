package com.guetunknow.imagewall.Activities;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.guetunknow.imagewall.DataBaseHelper.MySQLUtils;
import com.guetunknow.imagewall.Fragments.AddFragment;
import com.guetunknow.imagewall.Fragments.HomeFragment;
import com.guetunknow.imagewall.Fragments.ProfileFragment;
import com.guetunknow.imagewall.R;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottom_navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        开启子线程连接数据库
        需要使用时，直接 MySQL.getConnection() 方法获取连接对象
        不需要再次连接
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                MySQLUtils.setConn();
            }
        }).start();

        bottom_navigation = findViewById(R.id.bottom_navigation);
        bottom_navigation.setOnNavigationItemSelectedListener(this);//导航栏监听

      //加载fragment
        Bundle intent = getIntent().getExtras();
        if (intent != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new ProfileFragment()).commit();
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
        }

    }


    //导航栏监听事件
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_add:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AddFragment()).commit();
                break;
            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ProfileFragment()).commit();
                break;
            case R.id.nav_home:
            default:getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        //在MainActivity销毁前关闭数据库连接
        MySQLUtils.close(MySQLUtils.getConn());
        super.onDestroy();
    }

}