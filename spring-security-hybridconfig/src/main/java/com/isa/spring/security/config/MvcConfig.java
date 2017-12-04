package com.isa.spring.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);

        registry.addViewController("/admin/admin.html");
        registry.addViewController("/user/user.html");
        registry.addViewController("/home.html");
        registry.addViewController("/anonymous.html");
        registry.addViewController("/login.html");
        registry.addViewController("/noaccess.html");

        registry.addViewController("/accessible_with_viewcontroller.html");
        registry.addViewController("/accessible_with_viewcontroller");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        super.configureViewResolvers(registry);
        registry.jsp()
                .viewClass(JstlView.class)
                .prefix("/WEB-INF/view/")
                .suffix(".jsp");
    }

//    @Bean
//    public ViewResolver viewResolver() {
//        InternalResourceViewResolver bean = new InternalResourceViewResolver();
//        bean.setViewClass(JstlView.class);
//        bean.setPrefix("/WEB-INF/view/");
//        bean.setSuffix(".jsp");
//        return bean;
//    }
}