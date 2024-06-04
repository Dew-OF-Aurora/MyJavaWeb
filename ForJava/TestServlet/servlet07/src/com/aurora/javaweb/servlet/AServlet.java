package com.aurora.javaweb.servlet;

import com.aurora.javaweb.bean.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "A",urlPatterns = {"/a"},
        initParams = {@WebInitParam(name = "username",value = "Faker"),
                @WebInitParam(name = "pwd",value = "123")})
public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setID("123");
        user.setName("Jack");

        //转发
        req.setAttribute("user",user);
        req.getRequestDispatcher("/b").forward(req,resp);

        //重定向
        //resp.sendRedirect(req.getContextPath()+"/b");
    }
}
