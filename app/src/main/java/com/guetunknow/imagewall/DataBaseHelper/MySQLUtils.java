package com.guetunknow.imagewall.DataBaseHelper;

import android.util.Log;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLUtils {

    private static final String TAG = "MySQLUtils";

    private static final String url = "jdbc:mysql://139.9.119.150:3306/ImageWall";
    private static final String user = "dbadmin";
    private static final String password = "Manager123.";
    private static final String driverName = "com.mysql.jdbc.Driver";

    private static Connection conn = null;

    /**
     * 获取数据库连接对象
     * @return connection
     */
    public static Connection getConn() {
        return conn;
    }

    public static void setConn() {
        try {   //注册驱动
            Class.forName(driverName);
            Log.v(TAG, "加载JDBC驱动成功");
            try {//获取连接对象
                conn = (Connection) DriverManager.getConnection(url,user,password);
                Log.v(TAG, "数据库连接成功"+ conn.toString());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            Log.e(TAG,"加载JDBC驱动失败");
            e.printStackTrace();
        }
    }

    public static void close(Connection connection){
        if (connection != null){
            try {
                connection.close();
                System.out.println(connection.toString());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
