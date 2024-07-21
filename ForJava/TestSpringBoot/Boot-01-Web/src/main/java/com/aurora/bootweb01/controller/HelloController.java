package com.aurora.bootweb01.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUser() {
        return "GET-张三";
    }

    @PostMapping("/user")
    public String postUser() {
        return "Post-张三";
    }

    @DeleteMapping("/user")
    public String deleteUser() {
        return "delete-张三";
    }

    @PutMapping("/user")
    public String putUser() {
        return "put-张三";
    }

}
