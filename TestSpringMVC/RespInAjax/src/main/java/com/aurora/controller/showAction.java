package com.aurora.controller;

import com.aurora.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author:Aurora
 * @create: 2023-02-01 10:57
 * @Description:
 */
@Controller
public class showAction {

    @RequestMapping(value = "/show",method = RequestMethod.GET)
    @ResponseBody //处理ajax请求
    public List<User> showUser(){
        //如果使用ajax+拦截器, 那么正常情况下拦截器的跳转将会被禁止,前端ajax回调函数只会处理后端返回的数据(局部刷新)
        List<User> list = new ArrayList<>();
        list.add(new User("Alan","123"));
        list.add(new User("god","123"));
        return list;//对象自动转化为json
    }
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        dataBinder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
    }
    @RequestMapping("/mydate")
    public String showDate(Date mydate){
        System.out.println(new SimpleDateFormat().format(mydate));
        return "main";
    }
    @RequestMapping("/showlogin")
    public String showLogin(String name,String pwd){
        return "login";
    }
    @RequestMapping("/login")
    public String login(String name, String pwd, HttpServletRequest request){
        if ("Alan".equals(name) && "123".equalsIgnoreCase(pwd)){
            request.getSession().setAttribute("user",name);
            return "main";
        }
        return "showlogin";
    }
}
