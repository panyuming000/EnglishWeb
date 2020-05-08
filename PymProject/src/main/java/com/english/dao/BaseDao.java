package com.english.dao;


import com.english.entity.Word;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface BaseDao  {

    public void insertWords(@Param("list") List list,@Param("clmName") String clmNames,@Param("tableName") String tableName,@Param("paramNames") String paramNames);

    void insertWord(Word word);

    List normalSelect();
}
