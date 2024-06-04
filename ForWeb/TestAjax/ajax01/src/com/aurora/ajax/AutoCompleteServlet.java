package com.aurora.ajax;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

@WebServlet("/autocomplete")
public class AutoCompleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{

            Connection connection = DBUtil.getCon();
            String sql = "select content from java where content like ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,req.getParameter("text")+"%");
            resultSet = statement.executeQuery();
            List<Temp> strings = new ArrayList<>();
            while (resultSet.next()){
                //这里使用对象列表的话需要外部对象, 不能使用内部对象
                strings.add(new Temp(resultSet.getString("content")));
            }
            resp.setContentType("text/html;charset=UTF-8");
            String s = JSON.toJSONString(strings);
            resp.getWriter().println(s);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        finally {
            //DBUtil.close(null,statement,resultSet);
        }
    }
}
