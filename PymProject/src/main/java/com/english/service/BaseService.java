package com.english.service;

import com.english.dao.BaseDao;
import com.english.entity.Word;
import com.english.wordExtract.Top1;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public interface BaseService extends com.english.service.Service {

//    public void insertWords(String rPath,String wPath,String rMethod,String tableName);
    public void insertWord();
    public void insertRefer(Object obj);
}
