//IntelliJ IDEA
//mysecurity
//SysUserRepository
//2020/2/13
// Author:御承扬
//E-mail:2923616405@qq.com


package com.pyc.mysecurity.dao;

import com.pyc.mysecurity.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserRepository extends JpaRepository<SysUser, Long> {
    SysUser findByUsername(String username);
}
