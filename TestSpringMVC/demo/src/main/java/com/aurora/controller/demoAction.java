package com.aurora.controller;

import com.aurora.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author:Aurora
 * @create: 2023-01-17 17:06
 * @Description:
 */
@Controller
public class demoAction {
    /**
     * 需要符合action规范
     * 1. 访问权限是public
     * 2. 方法返回值任意(旧版servlet不能存在返回值)
     * 3. 方法名随意
     * 4. 方法没有参数,有可以是任意类型
     * 5. 需要使用@RequestMapping声明访问的路径
     */
    @RequestMapping(value = "/demo.action",method = RequestMethod.POST)
    public String demoPost(){
        System.out.println("post");
        return "main"; //可以直接跳转到/admin/main.jsp页面上
    }
    @RequestMapping(value = "/demo.action",method = RequestMethod.GET)
    public String demoGet(String name, String pwd){
        System.out.println("get");
        System.out.println(name+" "+pwd);
        return "main";
    }
    @RequestMapping(value = "/object.action",method = RequestMethod.GET)
    public String objectGet(User user){
        System.out.println(user);
        return "main";
    }
}
