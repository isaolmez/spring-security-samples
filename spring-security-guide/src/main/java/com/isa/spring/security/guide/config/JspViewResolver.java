package com.isa.spring.security.guide.config;

import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

public class JspViewResolver extends InternalResourceViewResolver {

  public JspViewResolver() {
    setViewClass(JstlView.class);
    setPrefix("/WEB-INF/view/");
    setSuffix(".jsp");
  }
}
