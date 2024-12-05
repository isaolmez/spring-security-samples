package com.isa.spring.security.guide.lesson8;

import org.springframework.context.annotation.Profile;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@Profile("lesson8")
public class HelloController {

  @Secured("ROLE_USER")
  @GetMapping(value = "/hello")
  public String hello() {
    return "Hello";
  }
}
