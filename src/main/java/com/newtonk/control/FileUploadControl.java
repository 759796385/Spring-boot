package com.newtonk.control;

import com.newtonk.service.UploadService;
import com.newtonk.util.DataHolder;
import com.newtonk.util.ExcelObject;
import com.newtonk.util.ExcelParse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.*;

/**
 * Created by newtonk on 2016/6/1.
 */
@RestController
@RequestMapping("/upload")
public class FileUploadControl {

    @Autowired
    private UploadService serice;

    @RequestMapping(value = "/excel",method = RequestMethod.POST)
    public ModelAndView upload(
            @RequestParam("file")MultipartFile file,
            HttpServletRequest req) throws IOException {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        Map result =new HashMap();
        if(file.isEmpty()){
            result.put("msg","操作失败");
            result.put("msg","文件未上传");
            mv.addObject("data",result);
            return mv;
        }
        InputStream myfile =file.getInputStream();
        Map<String,Integer> params =analysisParams(req);
        //使用index的key作为记录插入条数
        params.put("index",2);
        List<ExcelObject> datas = ExcelParse.start(myfile);
        try {
            serice.clearTable();
            serice.upload(datas, params);
            result.put("msg", "操作成功");
        }catch (DuplicateKeyException e){
            result.put("msg", "操作失败");
            Throwable throwable=e.getCause();
            String error= throwable.getMessage();
            int start= error.indexOf("entry");
            int end= error.indexOf("for");
            String message=  error.substring(start+5,end);
            result.put("reason","增加失败，数据："+message +" 已经存在...");
            String detailmsg = e.getMessage();
            start=detailmsg.indexOf("INSERT INTO");
            end = detailmsg.indexOf(" (");
            message = detailmsg.substring(start+11,end);
            result.put("table","表名："+message);
        }catch (DataIntegrityViolationException e){
            result.put("msg", "操作失败");
            Throwable throwable=e.getCause();
            String error= throwable.getMessage();
            if(error.contains("cannot be null")) {
                int start = error.indexOf("Column");
                int end = error.indexOf("cannot");
                String message = error.substring(start + 6, end);
                result.put("reason", "增加失败，列：" + message + " 不能为空...");
            }else if(error.contains("Data too long for column")){
                int start = error.indexOf("too long for column");
                int end = error.indexOf("at row");
                String message = error.substring(start + 19, end);
                result.put("reason", "增加失败，列：" + message + " 超过限定长度...");
            }else{
                result.put("reason",error);
            }
            String detailmsg = e.getMessage();
            int start = detailmsg.indexOf("INSERT INTO");
            int end = detailmsg.indexOf(" (",start);
            String message = detailmsg.substring(start + 11, end);
            result.put("table","表名："+message);
        }catch (ParseException e){
            result.put("msg", "操作失败");
            String error =e.getMessage();
            result.put("reason","数据解析失败，数据格式错误"+error);
        }
        result.put("line","当前行数:"+params.get("index"));

        mv.addObject("data",result);
        return mv;
    }



    /*解析参数，key为before，value为after*/
    public Map<String,Integer> analysisParams(HttpServletRequest req){
        if(!(req instanceof  StandardMultipartHttpServletRequest)){
            return null;
        }
        Map<String,Integer> result = new HashMap<String, Integer>();
        req = (StandardMultipartHttpServletRequest)req;
        Map<String, String[]> map =req.getParameterMap();
        Iterator<Map.Entry<String,String[]>> it = map.entrySet().iterator();
        DataHolder data = new DataHolder();
        while(it.hasNext()){
            Map.Entry<String,String[]> entry = it.next();
            String key =entry.getKey();
            Integer value = Integer.parseInt(entry.getValue()[0]);
            String[] strs = key.split("[.]");
            String method = strs[1];
            Integer index = Integer.parseInt(strs[0].substring(strs[0].indexOf("[")+1,strs[0].indexOf("]")));
            if(method.equals("before")){
                data.setBefore(value);
            }else if(method.equals("after")){
                data.setAfter(value);
                result.put(""+data.getBefore(),data.getAfter());
                data = new DataHolder();
            }
        }
        return result;
    }


}
