package com.isa.spring.security.guide.lesson7;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@Profile("lesson7")
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello";
    }
}
