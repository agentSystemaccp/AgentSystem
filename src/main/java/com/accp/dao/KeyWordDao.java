package com.accp.dao;

import com.accp.entity.Keyword;

public interface KeyWordDao {

    //查询关键词是否存在
    Keyword queryByKeyWord(Keyword keyword);
    //添加关键词
    int addKeyWord(Keyword keyword);
}
