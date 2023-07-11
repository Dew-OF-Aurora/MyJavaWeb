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
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String contextPath = req.getContextPath();
        try {
            con = DBUtil.getCon();
            String sql = "Select * from dept";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            int i = 0;
            while (rs.next()){
                String deptno = rs.getString("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                out.print("			<tr>");
                out.print("				<td>"+(++i)+"</td>");
                out.print("				<td>"+deptno+"</td>");
                out.print("				<td>"+dname+"</td>");
                out.print("				<td>");
                out.print("					<a href=''>删除</a>");
                out.print("					<a href='"+contextPath+"/edit?no="+deptno+"'>修改</a>");
                out.print("					<a href='detail.html'>详情</a>");
                out.print("				</td>");
                out.print("			</tr>");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            DBUtil.close(con,ps,rs);
        }
    }
}
