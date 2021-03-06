package com.isa.spring.security.guide.lesson8;

import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Profile("lesson8")
public class MethodSecurityConfig {

}
