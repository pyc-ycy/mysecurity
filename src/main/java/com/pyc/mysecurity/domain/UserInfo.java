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
public class UserInfo {
    @Id
    @GeneratedValue
    private Long id;

    private String name;    //username
    private String sex; // user sex
    private String add; // address
    private String mail;    // mail

    public UserInfo(){
        super();
    }
    public UserInfo(Long id, String name, String sex, String add, String mail){
        super();
        this.name=name;
        this.sex=sex;
        this.add=add;
        this.mail=mail;
        this.id=id;
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

    public void setAdd(String add) {
        this.add = add;
    }

    public String getAdd() {
        return add;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }
}
