package com.isa.spring.security.guide.lesson15;

import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@Profile("lesson15")
public class MethodSecurityConfig {

}
