//IntelliJ IDEA
//mysecurity
//WebController
//2020/2/13
// Author:御承扬
//E-mail:2923616405@qq.com

package com.pyc.mysecurity.web;

import com.pyc.mysecurity.dao.SysUserRepository;
import com.pyc.mysecurity.dao.UserinfoRepository;
import com.pyc.mysecurity.domain.Msg;
import com.pyc.mysecurity.domain.SysRole;
import com.pyc.mysecurity.domain.SysUser;
import com.pyc.mysecurity.domain.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.integration.dsl.mail.Mail;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {

    @RequestMapping("/")
    public String index(Model model, HttpSession session) {

        Msg msg = new Msg("Demo Title",
                "Demo Content",
                "additional msg, only admin can see");
        model.addAttribute("msg", msg);
        SecurityContextImpl securityContext = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
        String currentUser = ((UserDetails) securityContext.getAuthentication().getPrincipal()).getUsername();
        model.addAttribute("currentUser", currentUser);
        return "home";
    }

    @Autowired
    SysUserRepository userRepository;

    @Autowired
    UserinfoRepository userinfoRepository;

    @RequestMapping("/book")
    public String book(@Param("username") String username, @Param("password") String password) {
        int rs = (int) userRepository.count();
        SysRole role = new SysRole();
        role.setId((long) (2));
        role.setName("ROLE_USER");
        List<SysRole> ls = new ArrayList<>();
        ls.add(role);
        SysUser user = new SysUser();
        user.setId((long) rs + 1);
        user.setRoles(ls);
        user.setUsername(username);
        user.setPassword(password);
        userRepository.save(user);

        Userinfo userinfo = new Userinfo();
        userinfo.setName(username);
        userinfoRepository.save(userinfo);
        return "login";
    }

    @RequestMapping("/mail2pyl")
    public String mail2pyl() {
        return "mail2PYL";
    }

    @RequestMapping("/sendMail2PYL")
    public String sendMail2PYL(HttpSession session,Model model,
                               @Param("title") String title,
                               @Param("context") String context) {
        SecurityContextImpl securityContext = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
        String currentUser = ((UserDetails) securityContext.getAuthentication().getPrincipal()).getUsername();
        Userinfo userinfo = userinfoRepository.findByName(currentUser);
        if(userinfo.getStatus() != 1L){
            Msg msg = new Msg("Error Information",
                    "邮箱未激活,请到个人信息页面激活邮箱！",
                    "additional msg, only admin can see");
            model.addAttribute("msg", msg);
            return "error";
        }
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.163.com");
        mailSender.setPort(25);
        mailSender.setProtocol("smtp");
        mailSender.setUsername(userinfo.getMail());
        mailSender.setPassword(userinfo.getCode());
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(userinfo.getMail());
        message.setTo("2923616405@qq.com");
        message.setSubject(title);
        message.setText(context);
        mailSender.send(message);
        return "mail2PYL";
    }
    @RequestMapping("toRegistMail")
    public String toRegistMail(HttpSession session,Model model){
        SecurityContextImpl securityContext = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
        String currentUser = ((UserDetails) securityContext.getAuthentication().getPrincipal()).getUsername();
        Userinfo userinfo = userinfoRepository.findByName(currentUser);
        model.addAttribute("userinfo", userinfo);
        return "registMail";
    }
    @RequestMapping("/registMail")
    public String registMail(HttpSession session,Model model,
                             @Param("username") String username,
                             @Param("mail") String mail,
                             @Param("code") String code) {
        SecurityContextImpl securityContext = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
        String currentUser = ((UserDetails) securityContext.getAuthentication().getPrincipal()).getUsername();
        Userinfo userinfo = userinfoRepository.findByName(currentUser);
        if (username.equals(userinfo.getName()) && mail.equals(userinfo.getMail())){
            userinfoRepository.updateCode(code,1L,username,mail);
            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
            mailSender.setHost("smtp.163.com");
            mailSender.setPort(25);
            mailSender.setProtocol("smtp");
            mailSender.setUsername("15014366986@163.com");
            mailSender.setPassword(code);
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(userinfo.getMail());
            message.setTo(mail);
            message.setSubject("邮箱激活");
            message.setText("成功激活邮箱");
            mailSender.send(message);
            return "userInformation";
        }
        Msg msg = new Msg("Error Information",
                "邮箱错误，邮箱信息未注册到本网站。",
                "additional msg, only admin can see");
        model.addAttribute("msg", msg);
        return "error";
    }
}
