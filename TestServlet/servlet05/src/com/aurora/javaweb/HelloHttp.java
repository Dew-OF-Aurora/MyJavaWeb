package com.aurora.javaweb;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HelloHttp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("get http <br>");
        out.println(req);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("post http <br>");

        //
        out.println(req.getParameter("username"));
        //
        Map<String,String[]> map = req.getParameterMap();
        //Set<String> keys = map.keySet();
        //Iterator<String> it = keys.iterator();
        Enumeration<String> it = req.getParameterNames();
        while (it.hasMoreElements()){
            String key  = it.nextElement();
            String[] value = map.get(key);
            System.out.println(key);
            for (String a:value
                 ) {
                System.out.print(" "+a+"\n");
            }
        }
    }
}
