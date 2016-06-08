package com.newtonk.entity;

import java.util.Date;

/**
 * Created by newtonk on 2016/5/30.
 */
public class Mem_card_type extends BaseEntity{
    private String card_type_name;//卡类型名称
    private String card_type_desc;//卡类型描述
    private Double free_price;//赠送金额
    private String value_type;//储值类型 CASH, NUM,DATE,
    private int available;//有效
    private Date update_time;
    private Date create_time;
    private int val_days;//有效天数
    private String point_rate;//积分比例
    private String point_method;//积分方式
    private String bak;//备注
    private int card_cost;//每日可消费次数
    private int net_handle;//可网络办理
    private int card_id;//参考mem_card表一个物理卡号对应多个cardtype
    private Double sell_price;//售价
    private Double val_price;//卡面值
    private int val_num;//可消费次数
    private String put_off_style;//延期计算方式
    private String active_style;//OPEN(开卡即激活，USERED（使用即激活），TIMEING(使用即激活))
    private int active_days;//激活时间

    public Mem_card_type() {
        this.card_type_name="插入测试";
        this.value_type="NUM";
        this.put_off_style="CHARGE_DAY";
        this.active_style="USERED";
    }



    public String getCard_type_name() {
        return card_type_name;
    }

    public void setCard_type_name(String card_type_name) {
        this.card_type_name = card_type_name;
    }

    public String getCard_type_desc() {
        return card_type_desc;
    }

    public void setCard_type_desc(String card_type_desc) {
        this.card_type_desc = card_type_desc;
    }

    public Double getFree_price() {
        return free_price;
    }

    public void setFree_price(Double free_price) {
        this.free_price = free_price;
    }

    public String getValue_type() {
        return value_type;
    }

    public void setValue_type(String value_type) {
        this.value_type = value_type;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public int getVal_days() {
        return val_days;
    }

    public void setVal_days(int val_days) {
        this.val_days = val_days;
    }

    public String getPoint_rate() {
        return point_rate;
    }

    public void setPoint_rate(String point_rate) {
        this.point_rate = point_rate;
    }

    public String getPoint_method() {
        return point_method;
    }

    public void setPoint_method(String point_method) {
        this.point_method = point_method;
    }

    public String getBak() {
        return bak;
    }

    public void setBak(String bak) {
        this.bak = bak;
    }

    public int getCard_cost() {
        return card_cost;
    }

    public void setCard_cost(int card_cost) {
        this.card_cost = card_cost;
    }

    public int getNet_handle() {
        return net_handle;
    }

    public void setNet_handle(int net_handle) {
        this.net_handle = net_handle;
    }

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public Double getSell_price() {
        return sell_price;
    }

    public void setSell_price(Double sell_price) {
        this.sell_price = sell_price;
    }

    public Double getVal_price() {
        return val_price;
    }

    public void setVal_price(Double val_price) {
        this.val_price = val_price;
    }

    public int getVal_num() {
        return val_num;
    }

    public void setVal_num(int val_num) {
        this.val_num = val_num;
    }

    public String getPut_off_style() {
        return put_off_style;
    }

    public void setPut_off_style(String put_off_style) {
        this.put_off_style = put_off_style;
    }

    public String getActive_style() {
        return active_style;
    }

    public void setActive_style(String active_style) {
        this.active_style = active_style;
    }

    public int getActive_days() {
        return active_days;
    }

    public void setActive_days(int active_days) {
        this.active_days = active_days;
    }
}
