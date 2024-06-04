package com.aurora.javaweb;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

public class BServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object sysTime = req.getAttribute("sysTime");
        Date now = (Date) sysTime;
        resp.getWriter().println(now);
        resp.setContentType("text/html");
        resp.getWriter().println(this.getServletContext().getContextPath()+"<br>"+this.getServletContext().getRealPath("index.html"));

    }
}
