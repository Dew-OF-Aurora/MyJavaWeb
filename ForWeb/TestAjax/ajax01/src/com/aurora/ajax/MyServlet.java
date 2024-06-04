package com.aurora.ajax;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ajax/request")
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user1 = new User(req.getParameter("name"), req.getParameter("pwd"));
        List<User> users = new ArrayList<>();
        users.add(user1);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println(JSON.toJSONString(users));
    }

}
