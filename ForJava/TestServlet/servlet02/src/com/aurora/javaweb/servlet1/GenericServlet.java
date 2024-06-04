package com.aurora.javaweb.servlet1;

import jakarta.servlet.*;

import java.io.IOException;

public abstract class GenericServlet implements Servlet {

    private ServletConfig config;

    /**
     * 定义成final方法
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public final void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
        System.out.println("父类final init方法");
        this.init();
    }

    /**
     * 重载init,让之类能够重写该方法
     */
    public abstract void init();

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    /**
     *抽象方法, 子类必须实现
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public abstract void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException;


    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
