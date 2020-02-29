//IntelliJ IDEA
//mysecurity
//MailService
//2020/2/29
// Author:御承扬
//E-mail:2923616405@qq.com


package com.pyc.mysecurity.service;

public interface MailService {
    /**
     * 发送文本邮件
     * @param from 发件人
     * @param to 收件人
     * @param subject 主题
     * @param content 内容
     */
    void sendSimpleMail(String from,String to, String subject, String content);
}
