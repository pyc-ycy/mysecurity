//IntelliJ IDEA
//mysecurity
//CustomUserService
//2020/2/13
// Author:御承扬
//E-mail:2923616405@qq.com

package com.pyc.mysecurity.service;

import com.pyc.mysecurity.dao.SysUserRepository;
import com.pyc.mysecurity.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// 自定义需实现 UserDetailsService 接口
// Custom service needs to implement UserDetailsService interface
@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    SysUserRepository userRepository;

    // overwrite loadUserByUsername method to get account
    @Override
    public UserDetails loadUserByUsername(String username){
        SysUser user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        return user;
    }
}
