package com.aurora.javaweb;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

public class BServlet extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        ServletContext application = this.getServletContext();
        Object Userobj = application.getAttribute("userobj");
        out.println(Userobj);

    }
}
