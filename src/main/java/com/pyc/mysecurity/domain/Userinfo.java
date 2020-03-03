//IntelliJ IDEA
//mysecurity
//UserInfo
//2020/2/27
// Author:御承扬
//E-mail:2923616405@qq.com

package com.pyc.mysecurity.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Userinfo {
    @Id
    @GeneratedValue
    private Long id;

    private String name;    //username
    private String sex; // user sex
    private String address; // address
    private String mail;    // mail
    private Long status;
    private String code;
    private String touser;
    public Userinfo() {
        super();
    }

    public Userinfo(Long id, String name, String sex, String address, String mail) {
        super();
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.mail = mail;
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setAdd(String address) {
        this.address = address;
    }

    public String getAdd() {
        return address;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getStatus() {
        return status;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTouser() {
        return touser;
    }
}
