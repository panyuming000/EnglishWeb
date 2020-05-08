package com.english.serviceImpl;

import com.english.dao.BaseDao;
import com.english.entity.Word;
import com.english.service.BaseService;
import com.english.wordExtract.Top1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BaseServiceImpl implements BaseService{

    @Autowired(required = true)
    BaseDao baseDao;

    public BaseServiceImpl(){}
    public void insertWords(String rPath,String wPath,String rMethod,String tableName) throws IOException {
        List list = new ArrayList();
        List newList=null;
        int index=0;
        int len=400;
        try {
            list = Top1.extract(rPath,wPath,rMethod);
        } catch (Exception e) {
            e.printStackTrace();
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(wPath));
        writer.write(list.toString());
        System.out.println("BaseService-----------"+list);
        baseDao.insertWords(list,"base","wordBase","${item}");
    }

    @Override
    public void insertWord() {}
//    public void insertWord(){
//        List list = new ArrayList<Word>();
//        List newList=null;
//        int index=0;
//        int len=1;
//        try {
//            list = Top1.extract("/pan/IoFile/English/english.txt","/pan/IoFile/English/yinbiso.txt");
//        }catch(Exception e) {
//            e.printStackTrace();
//        }for(Object ss :list){
//            baseDao.insertWord((Word) ss);
//        }
////        baseDao.insertWord(new Word("","",""));
//    }

    @Override
    public void insertRefer(Object obj) {
//        baseDao.insertRefer();
    }

}
