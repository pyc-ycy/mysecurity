//IntelliJ IDEA
//mysecurity
//UserInfoController
//2020/2/27
// Author:御承扬
//E-mail:2923616405@qq.com

package com.pyc.mysecurity.web;

import com.pyc.mysecurity.dao.UserinfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserinfoController {
    @Autowired
    UserinfoRepository userInfoRepository;

}
