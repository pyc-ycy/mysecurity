//IntelliJ IDEA
//mysecurity
//Msg
//2020/2/13
// Author:御承扬
//E-mail:2923616405@qq.com

package com.pyc.mysecurity.domain;

public class Msg {
    private String title;
    private String content;
    private String etraInfo;

    public Msg(String title, String content, String etraInfo){
        super();
        this.content=content;
        this.title=title;
        this.etraInfo=etraInfo;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setEtraInfo(String etraInfo) {
        this.etraInfo = etraInfo;
    }

    public String getEtraInfo() {
        return etraInfo;
    }
}
