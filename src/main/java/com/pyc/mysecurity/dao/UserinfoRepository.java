//IntelliJ IDEA
//mysecurity
//UserInfoRepository
//2020/2/27
// Author:御承扬
//E-mail:2923616405@qq.com


package com.pyc.mysecurity.dao;

import com.pyc.mysecurity.domain.Userinfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserinfoRepository extends JpaRepository<Userinfo, Long> {
    Userinfo findByName(String name);
}
