package com.example.kings.myapplication.vo;

import java.io.Serializable;

public class NoticeVO implements Serializable {
    private static final long serialVersionUID = 2L;
    private String s_notiSubject;
    private String s_notiContent;

    public NoticeVO(String s_notiSubject, String s_notiContent) {
        this.s_notiSubject = s_notiSubject;
        this.s_notiContent = s_notiContent;
    }

    public String getS_notiSubject() {
        return s_notiSubject;
    }

    public void setS_notiSubject(String s_notiSubject) {
        this.s_notiSubject = s_notiSubject;
    }

    public String getS_notiContent() {
        return s_notiContent;
    }

    public void setS_notiContent(String s_notiContent) {
        this.s_notiContent = s_notiContent;
    }
}
