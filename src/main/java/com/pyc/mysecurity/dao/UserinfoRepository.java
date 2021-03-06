//IntelliJ IDEA
//mysecurity
//UserInfoRepository
//2020/2/27
// Author:御承扬
//E-mail:2923616405@qq.com


package com.pyc.mysecurity.dao;

import com.pyc.mysecurity.domain.Userinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserinfoRepository extends JpaRepository<Userinfo, Long> {
    Userinfo findByName(String name);
    @Modifying
    @Transactional
    @Query("update Userinfo u set u.sex=?1,u.address=?2, u.mail=?3 where u.name=?4")
    int update(String sex, String address, String mail, String name);

    @Modifying
    @Transactional
    @Query("update Userinfo u set u.code=?1,u.status=?2 where u.name=?3 and u.mail=?4")
    int updateCode(String code, Long status,String name, String mail);

    @Modifying
    @Transactional
    @Query("update Userinfo u set u.touser=?1 where u.name=?2")
    int updateTOUSER(String touser,String username);
}
