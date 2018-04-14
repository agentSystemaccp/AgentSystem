package com.accp.biz;

import com.accp.entity.Keyword;
import com.accp.entity.UserInfo;

public interface KeywordBiz {
    //动态验证关键词是否存在
    Keyword queryByKeyWord(Keyword keyword);

    int addKeyWord(Keyword keyword, UserInfo userInfo,int price);
}
