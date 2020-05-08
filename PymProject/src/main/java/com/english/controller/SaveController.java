package com.english.controller;

import com.english.entity.ReferWord;
import com.english.entity.RequestJsonData;
import com.english.entity.Word;
import com.english.exception.ServiceNotFindException;
import com.english.serviceImpl.ServiceFactor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class SaveController {

    @Autowired
    ServiceFactor serviceFactor;

    @PostMapping("/referInsert")
    public Object referSelect(@RequestParam("wids") String wids, @RequestParam("referText") String text, Map map) throws Exception {
        String []arr=wids.substring(1,wids.length()-1).split(",");
        List ids = new ArrayList();
        for(int a=0;a<arr.length;a++){
            ids.add(Integer.parseInt(arr[a]));
        }if(text.equals("")||text==null){return "{success:false}";}
        ReferWord referWord = new ReferWord(text,ids);
        serviceFactor.invoke("insertEnglishServiceImpl","referInsert",referWord);
        RequestJsonData json = new RequestJsonData();
        return json;
    }
    //单词的插入(3500词汇)
    @PostMapping("/insertWord")
    public Object insertWord1(Word word) throws ServiceNotFindException {
       Integer a = (Integer) serviceFactor.invoke("insertEnglishServiceImpl","insertWord",word);
       RequestJsonData json = new RequestJsonData();
       if(a==0||a==null){json.setSuccess(false);return json;}
       return json;
    }
    //1万词汇
    @PostMapping("/insertWord_s")
    public Object insertWord2(Word word) throws ServiceNotFindException {
        Integer a = (Integer) serviceFactor.invoke("insertEnglishServiceImpl","insertWord_s",word);
        RequestJsonData json = new RequestJsonData();
        if(a==0||a==null){json.setSuccess(false);return json;}
        return json;
    }
    @PostMapping("/baseCn")
    public Object insertWord3(@RequestParam("baseName") String name,@RequestParam("baseValue") String value) throws ServiceNotFindException {
        Integer a = (Integer) serviceFactor.invoke("insertEnglishServiceImpl","baseCn",value,name);
        RequestJsonData json = new RequestJsonData();
        if(a==0||a==null){json.setSuccess(false);return json;}
        return json;
    }
    //学过单词加标记
    @PostMapping("/wordIndex/{no}")
    public Object wordIndex(@PathVariable("no") Integer no) throws ServiceNotFindException {
        Integer a = (Integer) serviceFactor.invoke("insertEnglishServiceImpl","wordIndex",no);

        return null;
    }
    //词根增加翻译
    @PostMapping("/baseAddCn/{no}")
    public Object baseAddCn(@PathVariable("no") Integer no,@RequestParam("baseCn") String baseCn){
        return null;
    }
    //词根关联变体

}
