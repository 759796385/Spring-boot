package com.newtonk.entity;

import java.util.Date;

public class Rl_cardtype_card extends BaseEntity{

    private String mcCode;

    private Integer cardTypeId;//card_type

    private Double cardLeftBalance;

    private Date createDay;

    private Integer cardLeftNum;

    private Date endDay;

    private Integer available;

    private Date updateBy;

    private Integer cardCost;

    private Integer hasCost;

    private Integer state;

    private Double feeMinus;

    private Double maxAccount;

    private Double leftAccount;

    public Rl_cardtype_card() {
    }

    public Rl_cardtype_card(String mcCode, Double cardLeftBalance, Integer cardLeftNum, Date createDay, Date endDay) {
        this.updateBy = new Date();
        this.available=1;
        this.mcCode = mcCode;
        this.cardLeftBalance = cardLeftBalance;
        this.createDay = createDay;
        this.endDay = endDay;
        this.cardLeftNum = cardLeftNum;
    }

    public String getMcCode() {
        return mcCode;
    }

    public void setMcCode(String mcCode) {
        this.mcCode = mcCode == null ? null : mcCode.trim();
    }

    public Integer getCardTypeId() {
        return cardTypeId;
    }

    public void setCardTypeId(Integer cardTypeId) {
        this.cardTypeId = cardTypeId;
    }

    public Double getCardLeftBalance() {
        return cardLeftBalance;
    }

    public void setCardLeftBalance(Double cardLeftBalance) {
        this.cardLeftBalance = cardLeftBalance;
    }

    public Date getCreateDay() {
        return createDay;
    }

    public void setCreateDay(Date createDay) {
        this.createDay = createDay;
    }

    public Integer getCardLeftNum() {
        return cardLeftNum;
    }

    public void setCardLeftNum(Integer cardLeftNum) {
        this.cardLeftNum = cardLeftNum;
    }

    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public Date getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Date updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getCardCost() {
        return cardCost;
    }

    public void setCardCost(Integer cardCost) {
        this.cardCost = cardCost;
    }

    public Integer getHasCost() {
        return hasCost;
    }

    public void setHasCost(Integer hasCost) {
        this.hasCost = hasCost;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Double getFeeMinus() {
        return feeMinus;
    }

    public void setFeeMinus(Double feeMinus) {
        this.feeMinus = feeMinus;
    }

    public Double getMaxAccount() {
        return maxAccount;
    }

    public void setMaxAccount(Double maxAccount) {
        this.maxAccount = maxAccount;
    }

    public Double getLeftAccount() {
        return leftAccount;
    }

    public void setLeftAccount(Double leftAccount) {
        this.leftAccount = leftAccount;
    }
}