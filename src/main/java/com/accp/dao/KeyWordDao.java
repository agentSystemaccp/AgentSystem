package com.accp.dao;

import com.accp.entity.Keyword;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KeyWordDao {

    //查询关键词是否存在
    Keyword queryByKeyWord(Keyword keyword);
    //添加关键词
    int addKeyWord(Keyword keyword);
    //关键词申请管理
    List<Keyword> queryKeyWordList(@Param("keyword")String keyword, @Param("offset") int offset, @Param("pageSize") int pageSize);

    int queryKeyWordCount(@Param("keyword") String keyword);
}
