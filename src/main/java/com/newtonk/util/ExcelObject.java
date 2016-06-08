package com.newtonk.util;


import com.newtonk.entity.Mem_card;
import com.newtonk.entity.Mem_member;
import com.newtonk.entity.Rl_cardtype_card;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by newtonk on 2016/6/2.
 */
public class ExcelObject {
    //mem_member
    private String member_name;
    private String sex;
    private String phone;
    private String cardId;
    private String birthday;
    private String mail;
    private String remarks;
    private String state;
    //mem_card
    private String mcCode;//old cardtypeid
    //rl_cardtype_card
    private String cardTypeId;//card_type
    private String cardLeftBalance;
    private String cardLeftNum;
    private Date createDay;//2013/1/2  10:00:00
    private Date endDay;//2020/10/20  10:00:00

    public ExcelObject() {
    }

    String[] str = {"LOSE_VALUE","NOMAL","STOP","NO_EXESIT","BACK"};
    private List<String> enums = new ArrayList<String>(Arrays.asList(str));

    public ExcelObject(String member_name, String sex, String phone, String cardId, String birthday, String mail, String remarks, String mcCode, String cardTypeId, String cardLeftBalance, String cardLeftNum, Date createDay, Date endDay,String state) {
        this.member_name = member_name;
        this.sex = sex;
        this.phone = phone;
        this.cardId = cardId;
        this.birthday = birthday;
        this.mail = mail;
        this.remarks = remarks;
        this.mcCode = mcCode;
        this.cardTypeId = cardTypeId;
        this.cardLeftBalance = cardLeftBalance;
        this.cardLeftNum = cardLeftNum;
        if(createDay==null){
            this.createDay=new Date();
        }else{
            this.createDay = createDay;
        }
        this.endDay = endDay;
        if(enums.contains(state)) {
            this.state = state;
        }else {
            this.state=null;
        }
    }

    public Mem_member getMem_member(){
        return  new Mem_member(member_name,sex,phone,cardId,birthday,mail,remarks);
    }


    public Mem_card getMem_card(){
        return new Mem_card(mcCode,state);
    }

    /*需要手动设置cardtypeid*/
    public Rl_cardtype_card getRl_cardtype_card() throws ParseException {
        Double balance = "".equals(cardLeftBalance)?0:Double.parseDouble(cardLeftBalance);
        Integer leftNum = "".equals(cardLeftNum)?0:Integer.parseInt(cardLeftNum);
        return new Rl_cardtype_card(mcCode,balance,leftNum,createDay,endDay);
    }

    public String getOldcardId(){
        return cardTypeId;
    }
}
