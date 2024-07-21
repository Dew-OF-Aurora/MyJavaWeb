package com.aurora.bootweb01.controller;

import com.aurora.bootweb01.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
public class TestController {

    @RequestMapping(value = "/submitForm", method = RequestMethod.POST)
    public String getForm(Map<String, Object> map, @RequestBody String formContent) throws JsonProcessingException {
        map.put("example", "Hello");
        map.put("formData", formContent);
        return map.toString();
    }

    @GetMapping("/getUser")
    public User getUser() {
        return User.builder().name("Aurora").pwd("123").build();
    }
}
