package com.aurora.javaweb;

import jakarta.servlet.annotation.WebServlet;

public class ReflectAnnotation {
    public static void main(String[] args) throws ClassNotFoundException {

        Class<?> AServletClass = Class.forName("com.aurora.javaweb.servlet.AServlet");
        if (AServletClass.isAnnotationPresent(WebServlet.class)){
            WebServlet aServletClassAnnotation = AServletClass.getAnnotation(WebServlet.class);
            String[] value = aServletClassAnnotation.value();
            String[] urlPatterns = aServletClassAnnotation.urlPatterns();
            for (String s : urlPatterns) {
                System.out.println(s);
            }
        }
    }
}
