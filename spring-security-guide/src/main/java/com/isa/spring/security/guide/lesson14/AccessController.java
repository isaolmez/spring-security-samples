package com.isa.spring.security.guide.lesson14;

import org.springframework.context.annotation.Profile;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@Profile("lesson14")
public class AccessController {

    @PreAuthorize("hasRole('USER')")
    @GetMapping(value = "/user")
    public String user() {
        return "USER";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/admin")
    public String admin() {
        return "ADMIN";
    }

    @PreAuthorize("hasRole('ADMIN') AND hasRole('USER')")
    @GetMapping(value = "/userAndAdmin")
    public String userAndAdmin() {
        return "USER AND ADMIN";
    }
}
