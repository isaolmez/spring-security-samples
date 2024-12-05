package com.isa.spring.security.guide.lesson13;

import com.isa.spring.security.guide.config.JspViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
@Profile("lesson13")
public class WebMvcConfig extends WebMvcConfigurerAdapter {

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    super.addViewControllers(registry);

    registry.addViewController("/").setViewName("index");
  }

  @Bean
  public ViewResolver viewResolver() {
    return new JspViewResolver();
  }
}
