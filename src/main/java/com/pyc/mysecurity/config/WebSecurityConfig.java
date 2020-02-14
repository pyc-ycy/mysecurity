//IntelliJ IDEA
//mysecurity
//WebSecurityConfig
//2020/2/13
// Author:御承扬
//E-mail:2923616405@qq.com

package com.pyc.mysecurity.config;

import com.pyc.mysecurity.service.CustomUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

// 拓展的 Spring Security 配置需要继承 WebSecurityConfigurerAdapter
// extend spring security need to extend WebSecurityConfigurerAdapter
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // booking a bean of CustomUserService
    @Bean
    UserDetailsService customUserService(){
        return new CustomUserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 添加自定义的 user detail service 认证
        // add custom user detail service authentication
        auth.userDetailsService(customUserService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // any request must to authorize so that can login
        http.authorizeRequests().anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                .permitAll()
                .and()
                .logout().permitAll();
        http.csrf().disable();
    }
}
