package com.accp.biz;

import com.accp.entity.DealDetail;
import com.accp.entity.Keyword;
import com.accp.entity.Page;
import com.accp.entity.UserInfo;

public interface KeywordBiz {
    //动态验证关键词是否存在
    Keyword queryByKeyWord(Keyword keyword);

    int addKeyWord(Keyword keyword, UserInfo userInfo,int price) throws Exception;

    //查看账户明细
    Page<Keyword> queryKeyWordList(String keyword,int userId, int pageSize, int pageNo);
    //根据id得到关键词
    Keyword queryKeyWordById(int keywordId);

    //修改关键词
    int updateKeyWord(Keyword keyword,UserInfo userInfo,int price) throws Exception;
}
