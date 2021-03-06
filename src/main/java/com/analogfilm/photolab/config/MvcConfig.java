package com.analogfilm.photolab.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/notFound").setViewName("error/404");
        registry.addViewController("/serverError").setViewName("error/500");
        registry.addViewController("/access-denied").setViewName("error/accessDenied");
    }
}
