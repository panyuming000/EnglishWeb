package com.english.serviceImpl;

import com.english.adapt.ServiceAdapt;
import com.english.dao.InsertEnglishDao;
import com.english.entity.ReferWord;
import com.english.entity.Word;
import com.english.service.InsertEnglishService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsertEnglishServiceImpl implements InsertEnglishService {

    @Autowired
    InsertEnglishDao dao;
    public InsertEnglishServiceImpl(){}
    public int referInsert(ReferWord referWord){
//        String refer =  referWord.getRefer();
        List list = referWord.getWids();
        int id = dao.referInsert(referWord);
        dao.referFound(list,referWord.getId());
        return 0;
    }

    @Override
    public int baseCn(String param1, String param2) {
        int a = dao.baseCn(param1,param2);
        if(a==0){
            dao.insertBase(param1,param2);
        }
        return a;
    }

    public int insertWord(Word word){
       return dao.insertWord(word);
    }

}
