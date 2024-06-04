package com.aurora.javaweb;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

public class AServlet extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        ServletContext application = this.getServletContext();
        //application.getContextPath();
        //
        //System.out.println(application.getRealPath("/index.jsp"));
        out.println(application.getRealPath("/web.xml")+"<br>");
        out.println(application.getContextPath()+"<br>");
        //记录到/CATALINA_HOME/logs
        application.log("test log");
        application.log("log:",new RuntimeException("this is a log test"));
        //
        User user = new User("jack","123");
        application.setAttribute("userobj",user);
        Object Userobj = application.getAttribute("userobj");
        out.println(Userobj);
    }
}
