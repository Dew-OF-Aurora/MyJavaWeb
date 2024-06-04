package com.aurora.ajax;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * JDBC工具类
 *
 * @author 196266
 * @version 2.0
 */
public class DBUtil {

    private static ResourceBundle bundle = ResourceBundle.getBundle("resources/jdbc");
    private static String driver = bundle.getString("driver");
    private static String url = bundle.getString("url");
    private static String user = bundle.getString("user");
    private static String password = bundle.getString("password");
    private static ThreadLocal<Connection> local = new ThreadLocal<>();

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //使用私有的构造方法,不让创建对象
    private DBUtil() {
    }

    /**
     * 获取数据库连接对象, 且不自动更新
     *
     * @return Connection
     * @throws SQLException
     */
    public static Connection getCon() throws SQLException {
        Connection connection = local.get();
        if (connection == null) {
            local.set(DriverManager.getConnection(url, user, password));
        }
        //需要再获取一次
        connection = local.get();
        return connection;

    }

    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
                local.remove();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (preparedStatement != null) {
            preparedStatement.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
