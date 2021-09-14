package com.tms;

import com.tms.interceptor.ControllerInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan(basePackages = "com.tms")
@EnableWebMvc
public class WebConfiguration extends WebMvcConfigurerAdapter {
    private final ControllerInterceptor controllerInterceptor;

    public WebConfiguration(ControllerInterceptor controllerInterceptor) {
        this.controllerInterceptor = controllerInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(controllerInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/user", "/user/reg", "/user/auth", "/user/notRegistered", "/calc/calculate");
    }
}
