//IntelliJ IDEA
//mysecurity
//WebController
//2020/2/13
// Author:御承扬
//E-mail:2923616405@qq.com

package com.pyc.mysecurity.web;

import com.pyc.mysecurity.dao.SysUserRepository;
import com.pyc.mysecurity.domain.Msg;
import com.pyc.mysecurity.domain.SysRole;
import com.pyc.mysecurity.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    SysUserRepository userRepository;

    @RequestMapping("/book")
    public String book(@Param("username")String username, @Param("password")String password){
        int rs = (int) userRepository.count();
        SysRole role = new SysRole();
        role.setId((long) (2));
        role.setName("ROLE_USER");
        List<SysRole> ls = new ArrayList<>();
        ls.add(role);
        SysUser user = new SysUser();
        user.setId((long)rs+1);
        user.setRoles(ls);
        user.setUsername(username);
        user.setPassword(password);
        userRepository.save(user);
        return "login";
    }

}
