package com.example.kings.myapplication.vo;

import java.io.Serializable;

public class UserVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String s_userNo;
    private String s_userId;
    private String s_userName;

    public UserVO(String s_userNo, String s_userId, String s_userName) {
        this.s_userNo = s_userNo;
        this.s_userId = s_userId;
        this.s_userName = s_userName;
    }

    public String getS_userNo() {
        return s_userNo;
    }

    public void setS_userNo(String s_userNo) {
        this.s_userNo = s_userNo;
    }

    public String getS_userId() {
        return s_userId;
    }

    public void setS_userId(String s_userId) {
        this.s_userId = s_userId;
    }

    public String getS_userName() {
        return s_userName;
    }

    public void setS_userName(String s_userName) {
        this.s_userName = s_userName;
    }
}