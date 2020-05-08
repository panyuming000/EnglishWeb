package com.english.service;

import com.english.entity.ReferWord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InsertEnglishService extends Service{

    public int referInsert(ReferWord referWord);
    public int baseCn(String param1,String param2);
}
