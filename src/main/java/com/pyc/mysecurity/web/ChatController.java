//IntelliJ IDEA
//mysecurity
//ChatController
//2020/3/3
// Author:御承扬
//E-mail:2923616405@qq.com

package com.pyc.mysecurity.web;

import com.pyc.mysecurity.dao.UserinfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class ChatController {
    private String toUser;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    UserinfoRepository repository;

    @RequestMapping("/toUser")
    public String toUser(String username, HttpSession session, Model model){
        SecurityContextImpl securityContext = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
        this.toUser= ((UserDetails)securityContext.getAuthentication().getPrincipal()).getUsername();

        //repository.updateTOUSER(this.toUser,user);
        return "chat2PYL";
    }

    @MessageMapping("/chat2PYL")
    public void handleChat(Principal principal, String msg){
//        messagingTemplate.convertAndSendToUser(to,
//                "/queue/notifications",
//                principal.getName()+"-send:"+msg);
        if(principal.getName().equals("pyc")){
            messagingTemplate.convertAndSendToUser(toUser,
                    "/queue/notifications",
                    principal.getName()+"-send:"+msg + " " + toUser);
        }else{
            messagingTemplate.convertAndSendToUser("pyc",
                    "/queue/notifications",
                    principal.getName()+"-send:"+msg + " " + toUser);
        }
    }
}
