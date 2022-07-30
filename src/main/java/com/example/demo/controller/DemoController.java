package com.example.demo.controller;

import com.example.demo.model.DemoUser;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private DemoService service;

    @RequestMapping(value="selectUser",method = RequestMethod.GET) // http://localhost:8080/selectUser?userId=0001
    public DemoUser selectUser(@RequestParam(value = "userId") String userId) {
        return service.doSelect(userId);
    }
}