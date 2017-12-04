package com.isa.spring.security.controller;

import com.isa.spring.security.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloWorldController {

    private final ApplicationContext applicationContext;

    @Autowired
    public HelloWorldController(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @RequestMapping("/hello")
    public String hello(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Inside hello()");
        return "hello";
    }

}