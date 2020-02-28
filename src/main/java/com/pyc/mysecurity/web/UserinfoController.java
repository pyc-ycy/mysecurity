//IntelliJ IDEA
//mysecurity
//UserInfoController
//2020/2/27
// Author:御承扬
//E-mail:2923616405@qq.com

package com.pyc.mysecurity.web;

import com.pyc.mysecurity.dao.UserinfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Controller
public class UserinfoController {
    @Autowired
    UserinfoRepository userInfoRepository;
    @RequestMapping("/userInformation")
    public String toUser(Model model, HttpSession session){
        SecurityContextImpl securityContext = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
        String currentUser =  ((UserDetails)securityContext.getAuthentication().getPrincipal()).getUsername();
        model.addAttribute("currentUser", currentUser);
        return "userInformation";
    }
}
