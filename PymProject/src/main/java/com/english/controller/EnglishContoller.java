package com.english.controller;

import com.english.entity.RequestJsonData;
import com.english.entity.Word;
import com.english.exception.ServiceNotFindException;
import com.english.service.BaseService;
import com.english.serviceImpl.ServiceFactor;
import com.english.wordExtract.Top1;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class EnglishContoller {

    @Autowired
    ServiceFactor serviceFactor;
    @PostMapping("/page/{no}")
    public Object getPage(@PathVariable Integer no,@RequestParam(value = "pageSize",required = false) Integer pageSize ) throws Exception {
        if(pageSize==null||pageSize==0)pageSize=10;
        PageHelper.startPage(no,pageSize);
        Page<Word> page = (Page<Word>) serviceFactor.invoke("selectEnglishServiceImpl","normalSelect",null);
        RequestJsonData json = new RequestJsonData();
        json.setDatas(page);json.setPageNum(no);json.setPageTotal(page.getPages());json.setCountNum((int)page.getTotal());
        return json;
    }
    @RequestMapping("/likePage_s/{no}")
    public Object getLikePage3_s(@PathVariable("no") Integer no,@RequestParam("likeValue") String likeValue,@RequestParam(value = "pageSize",required = false) Integer pageSize ) throws ServiceNotFindException {
        if(pageSize==null||pageSize==0)pageSize=10;
        PageHelper.startPage(no,pageSize);
        Page page = (Page)serviceFactor.invoke("selectEnglishServiceImpl","wordLikeSelect_s",likeValue);
        return getRequestJsonData(page);
    }
    @RequestMapping("/wordLike/{no}")
    public Object getLikePage1(@PathVariable("no") Integer no,@RequestParam("likeValue") String likeValue,@RequestParam(value = "pageSize",required = false) Integer pageSize ) throws ServiceNotFindException {
        if(pageSize==null||pageSize==0)pageSize=10;
        PageHelper.startPage(no,pageSize);
        Page page = (Page)serviceFactor.invoke("selectEnglishServiceImpl","wordLikeSelect",likeValue);
        if(page==null||page.size()==0){
            PageHelper.startPage(no,pageSize);
            page = (Page)serviceFactor.invoke("selectEnglishServiceImpl","wordLikeSelect_s",likeValue);
        }
        RequestJsonData json = new RequestJsonData();
        json.setDatas(page);json.setPageNum(no);json.setPageTotal(page.getPages());json.setCountNum((int)page.getTotal());
        return json;
    }
    @RequestMapping("/wordLike_s/{no}")
    public Object getLikePage1_s(@PathVariable("no") Integer no,@RequestParam("likeValue") String likeValue,@RequestParam(value = "pageSize",required = false) Integer pageSize ) throws ServiceNotFindException {
        if(pageSize==null||pageSize==0)pageSize=10;
        PageHelper.startPage(no,pageSize);
        Page page = (Page)serviceFactor.invoke("selectEnglishServiceImpl","wordLikeSelect_s",likeValue);
        return getRequestJsonData(page);
    }
    @RequestMapping("/cnLike_s/{no}")
    public Object getLikePage2_s(@PathVariable("no") Integer no,@RequestParam("likeValue") String likeValue,@RequestParam(value = "pageSize",required = false) Integer pageSize ) throws ServiceNotFindException {
        if(pageSize==null||pageSize==0)pageSize=10;
        PageHelper.startPage(no,pageSize);
        Page page = (Page)serviceFactor.invoke("selectEnglishServiceImpl","cnLikeSelect_s",likeValue);
        return getRequestJsonData(page);
    }
    @RequestMapping("/cnLike/{no}")
    public Object getLikePage2(@PathVariable("no") Integer no,@RequestParam("likeValue") String likeValue,@RequestParam(value = "pageSize",required = false) Integer pageSize ) throws ServiceNotFindException {
        if(pageSize==null||pageSize==0)pageSize=10;
        PageHelper.startPage(no,pageSize);
        Page page = (Page)serviceFactor.invoke("selectEnglishServiceImpl","cnLikeSelect",likeValue);
        //如果没有查询到就去更广泛的范围查询
        if(page.size()<1||page==null){
            PageHelper.startPage(no,pageSize);
            page = (Page)serviceFactor.invoke("selectEnglishServiceImpl","cnLikeSelect_s",likeValue);
        }
        RequestJsonData json = new RequestJsonData();
        json.setDatas(page);json.setPageNum(no);json.setPageTotal(page.getPages());json.setCountNum((int)page.getTotal());
        return json;
    }
    //语句分解
    @PostMapping("/sentence/{no}")
    public Object sentence(@RequestParam("likeValue") String sentence,@PathVariable("no") Integer pageNum,@RequestParam(value = "pageSize",required = false) Integer pageSize) throws ServiceNotFindException {
        if(pageSize==null||pageSize==0)pageSize=10;
        PageHelper.startPage(pageNum,pageSize);
        List list = new ArrayList();
        Top1.joint3(sentence,list);
        Page page = (Page) serviceFactor.invoke("selectEnglishServiceImpl","sentence",list);
        return  getRequestJsonData(page);
    }
    @PostMapping("/sentence_s/{no}")
    public Object sentence_s(@RequestParam("likeValue") String sentence,@PathVariable("no") Integer pageNum,@RequestParam(value = "pageSize",required = false) Integer pageSize) throws ServiceNotFindException {
        if(pageSize==null||pageSize==0)pageSize=10;
        PageHelper.startPage(pageNum,pageSize);
        List list = new ArrayList();
        Top1.joint3(sentence,list);
        Page page = (Page) serviceFactor.invoke("selectEnglishServiceImpl","sentence_s",list);
        return  getRequestJsonData(page);
    }

    @RequestMapping("/test")
    public String test(){
        System.out.println("测试成功");
        return null;
    }
    //词根的分页
    @PostMapping("/basePage/{no}")
    public Object basePage1(@PathVariable("no") Integer pageNum,@RequestParam(value = "pageSize",required = false) Integer pageSize) throws ServiceNotFindException {
        if(pageSize==null||pageSize==0)pageSize=10;
        PageHelper.startPage(pageNum,pageSize);
        Page page = (Page)serviceFactor.invoke("selectEnglishServiceImpl","cnLikeSelect_s",null);
        return getRequestJsonData(page);
    }
    //3500对应词根查询
    @PostMapping("/baseLike/{no}")
    public Object basePage2(@RequestParam("likeValue") String likeValue,@PathVariable("no") Integer pageNum,@RequestParam(value = "pageSize",required = false) Integer pageSize) throws ServiceNotFindException {
        if(pageSize==null||pageSize==0)pageSize=10;
        PageHelper.startPage(pageNum,pageSize);
        Page page = (Page)serviceFactor.invoke("selectEnglishServiceImpl","baseLike",likeValue);
        return getRequestJsonData(page);
    }
    //1万词根对应查询
    @PostMapping("/baseLike_s/{no}")
    public Object basePage3(@RequestParam("likeValue") String likeValue,@PathVariable("no") Integer pageNum,@RequestParam(value = "pageSize",required = false) Integer pageSize) throws ServiceNotFindException {
        if(pageSize==null||pageSize==0)pageSize=10;
        PageHelper.startPage(pageNum,pageSize);
        Page page = (Page)serviceFactor.invoke("selectEnglishServiceImpl","baseLike_s",likeValue);
        return getRequestJsonData(page);
    }
    //单词查语句
    @PostMapping("/wordAndRefer/{no}")
    public Object wordAndRefer(@RequestParam("likeValue") Integer likeValue,@PathVariable("no") Integer pageNum,@RequestParam(value = "pageSize",required = false) Integer pageSize) throws ServiceNotFindException {
        if(pageSize==null||pageSize==0)pageSize=10;
        PageHelper.startPage(pageNum,pageSize);
        Page page = (Page)serviceFactor.invoke("selectEnglishServiceImpl","wordAndRefer",likeValue);
        return getRequestJsonData(page);
    }
    //语句查单词
    @PostMapping("/referAndWrod/{no}")
    public Object referAndWrod(@RequestParam("likeValue") Integer likeValue,@PathVariable("no") Integer pageNum,@RequestParam(value = "pageSize",required = false) Integer pageSize) throws ServiceNotFindException {
        if(pageSize==null||pageSize==0)pageSize=10;
        PageHelper.startPage(pageNum,pageSize);
        Page page = (Page)serviceFactor.invoke("selectEnglishServiceImpl","referAndWord",likeValue);
        return getRequestJsonData(page);
    }
    //根据时间查询语句
    @PostMapping("/timeRefer")
    public Object timeRefer(@RequestParam("likeValue") String likeValue,@RequestParam(value = "pageSize",required = false) Integer pageSize) throws ServiceNotFindException {
//        if(pageSize==null||pageSize==0)pageSize=10;
//        PageHelper.startPage(pageNum,pageSize);
        List page = (List)serviceFactor.invoke("selectEnglishServiceImpl","timeAndRefer",likeValue);
        RequestJsonData json = new RequestJsonData();json.setDatas(page);
        return json;
    }
    //获得语句
    //语句修改扩充(后期)

    //词根的变体




    public RequestJsonData getRequestJsonData(Page page){
        if(page==null)return null;
        RequestJsonData json = new RequestJsonData();
        json.setDatas(page);json.setPageNum(page.getPageNum());json.setPageTotal(page.getPages());json.setCountNum((int)page.getTotal());
        return json;
    }

}
