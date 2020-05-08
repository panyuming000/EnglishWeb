package com.english.dao;

import com.english.entity.ReferWord;
import com.english.entity.Word;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface InsertEnglishDao {

    public int referInsert(@Param("refer") ReferWord referWord);
    public void referFound(@Param("list") List list,@Param("refer") Integer refer);
    public int insertWord(@Param("word") Word word);

    public int baseCn(String param1,String param2);

    void insertBase(String param1, String param2);
}
