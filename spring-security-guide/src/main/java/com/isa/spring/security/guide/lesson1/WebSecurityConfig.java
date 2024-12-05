package com.isa.spring.security.guide.lesson1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@Profile("lesson1")
public class WebSecurityConfig {

  /***
   * In case of no security configuration,WebSecurityConfiguration->WebSecurityConfigurerAdapter configures the security
   *
   protected void configure(HttpSecurity http) throws Exception {
   http
   .authorizeRequests()
   .anyRequest().authenticated()
   .and()
   .formLogin()
   .and()
   .httpBasic();
   }
   */

  @Bean
  public UserDetailsService userDetailsService() {
    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    manager.createUser(User.withUsername("user").password("password").roles("USER").build());
    return manager;
  }
}
