package com.english.service;

import com.github.pagehelper.Page;

import java.util.ArrayList;
import java.util.List;

public interface SelectEnglishService extends com.english.service.Service {

    public List normalSelect();
    /**单词模糊查询*/
    public List wordLikeSelect(String condition);
    /**翻译模糊查询*/
    public List cnLikeSelect(String condition);

    /**单词扩展查询*/
    public List wordLikeSelect_s(String condition);
    /**翻译扩展查询*/
    public List cnLikeSelect_s(String condition);
    /**分解语句查出所有相关词汇*/
    public List likePage_s();
    public List sentence(ArrayList list);
    public List sentence_s(ArrayList list);
    public List basePage();
    public List baseLike(String condition);
    public List baseLike_s(String condition);
    public List wordAndRefer(Integer id);
    public List ReferAndWord(Integer id);
    public List timeAndRefer(String time);

}
