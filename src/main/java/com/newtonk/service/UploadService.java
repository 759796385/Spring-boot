package com.newtonk.service;

import com.newtonk.entity.Mem_card;
import com.newtonk.entity.Mem_card_type;
import com.newtonk.entity.Mem_member;
import com.newtonk.entity.Rl_cardtype_card;
import com.newtonk.mapper.Mem_cardMapper;
import com.newtonk.mapper.Mem_card_typeMapper;
import com.newtonk.mapper.Mem_memberMapper;
import com.newtonk.mapper.Rl_cardtype_cardMapper;
import com.newtonk.util.ExcelObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Created by newtonk on 2016/6/2.
 */
@Service
public class UploadService {

    @Autowired
    private Mem_memberMapper memberMapper;

    @Autowired
    private Mem_cardMapper cardMapper;

    @Autowired
    private Mem_card_typeMapper cardTypeMapper;

    @Autowired
    private Rl_cardtype_cardMapper rlcardMapper;

    public void upload(List<ExcelObject> datas, Map<String, Integer> params) throws DuplicateKeyException, ParseException {
        long start=0;
        long endtime=0;
        for (int i =0;i<datas.size();i++) {
            if(i%100==1) {
                start = System.currentTimeMillis();
            }
            ExcelObject data = datas.get(i);
            String oldtypeID = data.getOldcardId();
            Integer typeId=0;
            if(oldtypeID!="") {
                Integer newTypeId = params.get(oldtypeID);//新参数
                typeId = newTypeId == null ? Integer.parseInt(oldtypeID) : newTypeId;
            }
            saveTable(typeId,data);
            params.put("index",i+3);
            if(i%100==0) {
                endtime = System.currentTimeMillis();
                double cost = (endtime - start) / 1000;
                System.out.println("这"+i+"条数据用时"+cost+"秒");
            }
        }
    }
    @Transactional
    public void saveTable(Integer typeId,ExcelObject data) throws ParseException {
        Mem_card_type cardtype =cardTypeMapper.selectByPrimaryKey(typeId);
        if(cardtype==null){//插入卡类型
            cardtype = new Mem_card_type();
            cardtype.setId(typeId);
            cardTypeMapper.insert(cardtype);
        }
        Mem_card mem_card =data.getMem_card();
        Mem_member mem_member=data.getMem_member();
        Rl_cardtype_card rl_cardtype_card = data.getRl_cardtype_card();
        rl_cardtype_card.setCardTypeId(typeId);
        memberMapper.insertSelective(mem_member);
        mem_card.setMemberId(mem_member.getId());
        cardMapper.insertSelective(mem_card);
        rlcardMapper.insertSelective(rl_cardtype_card);
    }

    public void clearTable() {

        rlcardMapper.delete(new Rl_cardtype_card());
        rlcardMapper.setIncrementRestart();
        cardMapper.delete(new Mem_card());
        cardTypeMapper.setIncrementRestart();
        memberMapper.delete(new Mem_member());
        memberMapper.setIncrementRestart();
        cardTypeMapper.delete(new Mem_card_type());
        cardTypeMapper.setIncrementRestart();
    }
}
