//IntelliJ IDEA
//mysecurity
//WebController
//2020/2/13
// Author:御承扬
//E-mail:2923616405@qq.com

package com.pyc.mysecurity.web;

import com.pyc.mysecurity.domain.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    @RequestMapping("/")
    public String index(Model model){
        Msg msg = new Msg("Demo Title",
                "Demo Content",
                "additional msg, only admin can see");
        model.addAttribute("msg",msg);
        return "home";
    }
}
