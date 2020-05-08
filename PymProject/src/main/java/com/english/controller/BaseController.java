package com.english.controller;

import com.english.serviceImpl.ServiceFactor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/base")
public class BaseController {
    @Autowired
    ServiceFactor serviceFactor;


    @RequestMapping("/insert/{id}/{path}")
    public Object insertTable(@PathVariable("id") String id,@PathVariable("path") String path) throws Exception{
        if(id.equals("panyuming")){
            serviceFactor.invoke("baseServiceImpl","insertWords","/pan/IoFile/English/word1.txt");
        }else{
            throw new Exception("找不到页面");
        }
        return "";
    }

    @PostMapping("/insert")
    public Object insertTables(@RequestParam("id") String id, @RequestParam("rPath") String rPath, @RequestParam("wPath") String wPath, @RequestParam("rMethod") String rMetnod, @RequestParam("tableName") String tableName) throws Exception{
        if(id.equals("panyuming")){
            serviceFactor.invoke("baseServiceImpl","insertWords",rPath,wPath,rMetnod,tableName);
        }else{
            throw new Exception("找不到页面");
        }
        return "";
    }
    @RequestMapping("/test1")
    public Object insertTablesdfs() throws Exception{
        System.out.println("测试测试在测试,别放弃,别丧气 学会面对挫败");
        return "";
    }
}
