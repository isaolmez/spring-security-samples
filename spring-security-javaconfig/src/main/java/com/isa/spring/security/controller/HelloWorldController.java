package com.isa.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloWorldController {

    @RequestMapping("/hello")
    public String hello(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Inside hello()");
        return "hello";
    }

}