package com.aurora.ajax;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/jsonp2")
public class JsonpServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String callback = req.getParameter("callback");
        User user = new User("Aurora","123");
        resp.getWriter().println(callback + "("+ JSON.toJSONString(user) +")");
    }
}
