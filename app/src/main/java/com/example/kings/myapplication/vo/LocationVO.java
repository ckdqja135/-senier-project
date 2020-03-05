package com.example.kings.myapplication.vo;

public class LocationVO {
    private int    i_locationNo;
    private String s_locationName;
    private int    i_parentNo;

    public LocationVO(int i_locationNo, String s_locationName, int i_parentNo) {
        this.i_locationNo = i_locationNo;
        this.s_locationName = s_locationName;
        this.i_parentNo = i_parentNo;
    }

    public int getI_locationNo() {
        return i_locationNo;
    }

    public void setI_locationNo(int i_locationNo) {
        this.i_locationNo = i_locationNo;
    }

    public String getS_locationName() {
        return s_locationName;
    }

    public void setS_locationName(String s_locationName) {
        this.s_locationName = s_locationName;
    }

    public int getI_parentNo() {
        return i_parentNo;
    }

    public void setI_parentNo(int i_parentNo) {
        this.i_parentNo = i_parentNo;
    }
}
