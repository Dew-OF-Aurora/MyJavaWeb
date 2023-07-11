package com.aurora.javaweb.action;

import com.aurora.javaweb.util.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeptEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String no = req.getParameter("no");
        try {
            Connection con = DBUtil.getCon();
            PreparedStatement ps = con.prepareStatement("update dept set dname ='aurora' where deptno = ?");
            ps.setString(1,no);
            if (ps.executeUpdate()!= 0){
                out.print("<a href='"+req.getContextPath()+"/list'>修改成功</a>");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
