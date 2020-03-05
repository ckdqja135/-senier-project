package com.example.kings.myapplication.vo;

public class PcVO {
    private int    i_pcNo;
    private String s_pcName;
    private String s_pcTel;
    private String s_pcAddress;
    private String s_pcInfo;
    private int    i_pcProfile;
    private int    i_totalSeat;
    private int    i_useSeat;

    public PcVO(int i_pcNo, String s_pcName, String s_pcTel, String s_pcAddress, String s_pcInfo, int i_pcProfile, int i_totalSeat, int i_useSeat) {
        this.i_pcNo = i_pcNo;
        this.s_pcName = s_pcName;
        this.s_pcTel = s_pcTel;
        this.s_pcAddress = s_pcAddress;
        this.s_pcInfo = s_pcInfo;
        this.i_pcProfile = i_pcProfile;
        this.i_totalSeat = i_totalSeat;
        this.i_useSeat = i_useSeat;
    }

    public int getI_pcNo() {
        return i_pcNo;
    }

    public void setI_pcNo(int i_pcNo) {
        this.i_pcNo = i_pcNo;
    }

    public String getS_pcName() {
        return s_pcName;
    }

    public void setS_pcName(String s_pcName) {
        this.s_pcName = s_pcName;
    }

    public String getS_pcTel() {
        return s_pcTel;
    }

    public void setS_pcTel(String s_pcTel) {
        this.s_pcTel = s_pcTel;
    }

    public String getS_pcAddress() {
        return s_pcAddress;
    }

    public void setS_pcAddress(String s_pcAddress) {
        this.s_pcAddress = s_pcAddress;
    }

    public String getS_pcInfo() {
        return s_pcInfo;
    }

    public void setS_pcInfo(String s_pcInfo) {
        this.s_pcInfo = s_pcInfo;
    }

    public int getI_pcProfile() {
        return i_pcProfile;
    }

    public void setI_pcProfile(int i_pcProfile) {
        this.i_pcProfile = i_pcProfile;
    }

    public int getI_totalSeat() {
        return i_totalSeat;
    }

    public void setI_totalSeat(int i_totalSeat) {
        this.i_totalSeat = i_totalSeat;
    }

    public int getI_useSeat() {
        return i_useSeat;
    }

    public void setI_useSeat(int i_useSeat) {
        this.i_useSeat = i_useSeat;
    }
}
