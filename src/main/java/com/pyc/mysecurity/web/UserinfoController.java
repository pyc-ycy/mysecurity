//IntelliJ IDEA
//mysecurity
//UserInfoController
//2020/2/27
// Author:御承扬
//E-mail:2923616405@qq.com

package com.pyc.mysecurity.web;

import com.pyc.mysecurity.dao.UserinfoRepository;
import com.pyc.mysecurity.domain.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
        Userinfo userinfo = userInfoRepository.findByName(currentUser);
        model.addAttribute("userinfo", userinfo);
        return "userInformation";
    }

    @RequestMapping("/updateUserinfo")
    public String update(Model model, HttpSession session){
        SecurityContextImpl securityContext = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
        String currentUser =  ((UserDetails)securityContext.getAuthentication().getPrincipal()).getUsername();
        model.addAttribute("currentUser", currentUser);
        return "updateUserinfo";
    }
    @RequestMapping("/saveUserinfo")
    public String save(HttpSession session,
                       @Param("sex")String sex,
                       @Param("address")String address,
                       @Param("mail")String mail,
                       Model model){
        SecurityContextImpl securityContext = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
        String user =  ((UserDetails)securityContext.getAuthentication().getPrincipal()).getUsername();
        int result = userInfoRepository.update(sex, address, mail, user);
        if(result != 0){
            Userinfo userinfo = userInfoRepository.findByName(user);
            model.addAttribute("userinfo", userinfo);
            return "userInformation";
        }
        return "updateUserinfo";
    }
}
