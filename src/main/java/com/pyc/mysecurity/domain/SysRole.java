//IntelliJ IDEA
//mysecurity
//SysRole
//2020/2/13
// Author:御承扬
//E-mail:2923616405@qq.com

package com.pyc.mysecurity.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SysRole {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

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
}
