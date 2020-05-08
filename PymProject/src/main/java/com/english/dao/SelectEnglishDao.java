package com.english.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Mapper
@Component
public interface SelectEnglishDao {
    /**普通分页查询*/
    public List normalSelect();
    /**单词模糊查询*/
    public List wordLikeSelect(String condition);
    /**翻译模糊查询*/
    public List cnLikeSelect(String condition);
    /**查询关联语句*/
    public List referSelect(int id);
    /**查询词根*/
    public List wordBaseSelect(int id);

    public List cnLikeSelect_s(String condition);

    public List wordLikeSelect_s(String condition);

    public List likePage_s();

    public List sentence(@Param("list") List list);

    public List sentence_s(ArrayList list);
    public List basePage();
    public List baseLike(String condition);
    public List baseLike_s(String condition);

    public List referAndWord(Integer id);
    public List wordAndRefer(Integer id);
    public List timeAndRefer(String time);
}
