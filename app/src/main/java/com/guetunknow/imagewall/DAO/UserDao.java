package com.guetunknow.imagewall.DAO;

import android.util.Log;

import com.guetunknow.imagewall.Bean.User;
import com.guetunknow.imagewall.DataBaseHelper.MySQLUtils;
import com.mysql.jdbc.Connection;

import java.sql.PreparedStatement;

public class UserDao {
    private static final String TAG = "MySQLUtils";

    public void add(User user) {
        try {
            String sql = "insert into user(email,user_name,password) values(?,?,?)";
            // 使用预编译
            Connection conn = MySQLUtils.getConn();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2,user.getUser_name());
            ps.setString(3,user.getPassword());
            // 执行语句
            ps.executeUpdate();
            //关闭PreparedStatement
            ps.close();
            //控制台提示信息
            Log.e(TAG,"注册成功！");
        } catch (Exception e) {
            Log.e(TAG,"注册失败！");
            e.printStackTrace();
        }
    }

}
