package com.aurora.javaweb.servlet1;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;

public class UserServlet extends GenericServlet{
    /**
     * 抽象方法, 子类必须实现
     *
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("适配器设计模式");
        //拿到config
        ServletConfig config = this.getServletConfig();
    }

    @Override
    public void init() {
        System.out.println("子类init方法");
    }
}
