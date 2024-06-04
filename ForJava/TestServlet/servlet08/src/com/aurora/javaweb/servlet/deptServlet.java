package com.aurora.javaweb.servlet;

import com.aurora.javaweb.bean.User;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/dept/*")
public class deptServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Path = req.getRequestURI();

        if ((req.getContextPath()+"/dept/a").equals(Path)){
            doA(req,resp);
        }
        else if ((req.getContextPath()+"/dept/b").equals(Path)){
            doB(req,resp);
        }
    }

    private void doA(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //如果使用数据库需要循环添加
        User user = new User("Aurora","123");
        List<User> userList = new ArrayList<User>();
        userList.add(user);

        req.setAttribute("userList",userList);
        req.getRequestDispatcher( "/list.jsp").forward(req,resp);

    }

    private void doB(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("b");
    }

}
