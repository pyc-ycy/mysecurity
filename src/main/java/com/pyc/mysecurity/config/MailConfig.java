//IntelliJ IDEA
//mysecurity
//MailConfig
//2020/2/29
// Author:御承扬
//E-mail:2923616405@qq.com

package com.pyc.mysecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
    @Bean
    public JavaMailSender javaMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.163.com");
        mailSender.setUsername("15014366986@163.com");
        mailSender.setPassword("17845wy");
        return mailSender;
    }
}
