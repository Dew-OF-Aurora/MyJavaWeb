package com.aurora.javaweb.util;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * JDBC工具类
 */
public class DBUtil{

    private static ResourceBundle bundle = ResourceBundle.getBundle("resources.jdbc");
    private static String driver = bundle.getString("driver");
    private static String url = bundle.getString("url");
    private static String user = bundle.getString("user");
    private static String password = bundle.getString("password");

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接对象
     * @return Connection
     * @throws SQLException
     */
    public static Connection getCon() throws SQLException {

        Connection connection = DriverManager.getConnection(url,user,password);
        //PreparedStatement statement = connection.prepareStatement("select * from mysql");
        //ResultSet resultSet = statement.getResultSet();
        return connection;

    }

    public static void close(Connection connection, Statement ps, ResultSet rs){
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (ps != null){
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
