package com.aurora.javaweb.configtest;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * servletConfig
 */

public class ConfigTest extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        ServletConfig config = this.getServletConfig();
        out.print(config);
        out.print("<br>"+this.getServletName());

        Enumeration<String> initParameterNames = config.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String var1 = initParameterNames.nextElement();
            out.print("<br>"+var1);
            String var2 = getInitParameter(var1);
            out.print("'value:"+var2);
        }
        //System.out.println(this.getInitParameter("password"));
        System.out.println(this.getServletContext());
    }
}
