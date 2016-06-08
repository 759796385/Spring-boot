package com.newtonk.entity;

import java.util.Date;

public class Mem_card extends BaseEntity{

    private String mcType;

    private Integer memberId;

    private String mcCode;

    private Byte available;

    private Date updateTime;

    private String mcCodeMac;

    private String mcCodeVirtual;

    private String state;

    private Date stopBegin;

    private Date stopEnd;

    private String changeCode;

    public Mem_card() {
    }

    public Mem_card(String mcCode,String state) {
        this.updateTime=new Date();
        this.memberId=0;
        this.mcCode = mcCode;
        this.state = state;
    }

    public String getMcType() {
        return mcType;
    }

    public void setMcType(String mcType) {
        this.mcType = mcType == null ? null : mcType.trim();
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getMcCode() {
        return mcCode;
    }

    public void setMcCode(String mcCode) {
        this.mcCode = mcCode == null ? null : mcCode.trim();
    }

    public Byte getAvailable() {
        return available;
    }

    public void setAvailable(Byte available) {
        this.available = available;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getMcCodeMac() {
        return mcCodeMac;
    }

    public void setMcCodeMac(String mcCodeMac) {
        this.mcCodeMac = mcCodeMac == null ? null : mcCodeMac.trim();
    }

    public String getMcCodeVirtual() {
        return mcCodeVirtual;
    }

    public void setMcCodeVirtual(String mcCodeVirtual) {
        this.mcCodeVirtual = mcCodeVirtual == null ? null : mcCodeVirtual.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getStopBegin() {
        return stopBegin;
    }

    public void setStopBegin(Date stopBegin) {
        this.stopBegin = stopBegin;
    }

    public Date getStopEnd() {
        return stopEnd;
    }

    public void setStopEnd(Date stopEnd) {
        this.stopEnd = stopEnd;
    }

    public String getChangeCode() {
        return changeCode;
    }

    public void setChangeCode(String changeCode) {
        this.changeCode = changeCode == null ? null : changeCode.trim();
    }
}