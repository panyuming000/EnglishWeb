package com.english.serviceImpl;

import com.english.dao.SelectEnglishDao;
import com.english.service.SelectEnglishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SelectEnglishServiceImpl implements SelectEnglishService {

    @Autowired
    SelectEnglishDao selectEnglishDao;
    public SelectEnglishServiceImpl(){}
    @Override
    public List normalSelect() {
        return selectEnglishDao.normalSelect();
    }

    @Override
    public List wordLikeSelect(String condition) {
        condition="%"+condition+"%";
        List list = selectEnglishDao.wordLikeSelect(condition);
        return list;
    }

    @Override
    public List cnLikeSelect(String condition) {
        condition="%"+condition+"%";
        List list = selectEnglishDao.cnLikeSelect(condition);
        return list;
    }
    @Override
    public List wordLikeSelect_s(String condition) {
        condition="%"+condition+"%";
        List list = selectEnglishDao.wordLikeSelect_s(condition);
        return list;
    }

    @Override
    public List cnLikeSelect_s(String condition) {
        condition="%"+condition+"%";
        List list = selectEnglishDao.cnLikeSelect_s(condition);
        return list;
    }

    @Override
    public List likePage_s() {
        return selectEnglishDao.likePage_s();
    }

    @Override
    public List sentence(ArrayList list) {
        list=(ArrayList) selectEnglishDao.sentence(list);
        return list;
    }
    @Override
    public List sentence_s(ArrayList list) {
        list=(ArrayList) selectEnglishDao.sentence_s(list);
        return list;
    }

    @Override
    public List basePage() {

        List list =(ArrayList) selectEnglishDao.basePage();
        return list;
    }

    @Override
    public List baseLike(String condition) {
        condition="%"+condition+"%";
        List list =(ArrayList) selectEnglishDao.baseLike(condition);
        return list;
    }

    @Override
    public List baseLike_s(String condition) {
        condition="%"+condition+"%";
        List list =(ArrayList) selectEnglishDao.baseLike_s(condition);
        return list;
    }

    @Override
    public List wordAndRefer(Integer id) {
        List list = selectEnglishDao.wordAndRefer(id);
        return list;
    }

    @Override
    public List ReferAndWord(Integer id) {
        List list = selectEnglishDao.referAndWord(id);
        return null;
    }
    @Override
    public List timeAndRefer(String time) {
        List list = selectEnglishDao.timeAndRefer(time);
        return list;
    }


}
