package com.aurora.javaweb;

import jakarta.servlet.*;
import java.io.*;
import java.sql.*;

public class StudentServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest Request, ServletResponse Response) throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Response.setContentType("text/html"); //设置相应的内容类型
        PrintWriter out = Response.getWriter(); //使用打印流
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://192.168.50.241:3311/mysql";
            String usr = "root";
            String pwd = "root";
            conn = DriverManager.getConnection(url,usr,pwd);
            ps = conn.prepareStatement("select * from db");
            rs = ps.executeQuery();
            while(rs.next()){
                String var1 = rs.getString("Host");
                String var2 = rs.getString("User");
                out.print(var1 + "," + var2 + "<br>");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            if (rs != null) {try {rs.close();} catch (SQLException e) {e.printStackTrace();}}
            if (ps != null) { try {ps.close();} catch (SQLException e) {e.printStackTrace();}}
            if (conn != null) {try {conn.close();} catch (SQLException e) {e.printStackTrace();}}
        }

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
