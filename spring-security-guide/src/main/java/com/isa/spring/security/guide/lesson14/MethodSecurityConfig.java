package com.isa.spring.security.guide.lesson14;

import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@Profile("lesson14")
public class MethodSecurityConfig {

}
