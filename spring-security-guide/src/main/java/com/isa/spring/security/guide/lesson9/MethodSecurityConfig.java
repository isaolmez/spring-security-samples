package com.isa.spring.security.guide.lesson9;

import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Profile("lesson9")
public class MethodSecurityConfig {

}
