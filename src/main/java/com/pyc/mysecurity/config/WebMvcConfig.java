//IntelliJ IDEA
//mysecurity
//WebMvcConfig
//2020/2/13
// Author:御承扬
//E-mail:2923616405@qq.com

package com.pyc.mysecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/sign").setViewName("sign");
        registry.addViewController("/visitor/home").setViewName("vHome");
        registry.addViewController("/visitor/hbls").setViewName("hbls");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/lawyerInfo").setViewName("LawyerInformation");
    }
}
