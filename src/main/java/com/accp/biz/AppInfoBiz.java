package com.accp.biz;

import com.accp.entity.AppInfo;
import com.accp.entity.Keyword;

public interface AppInfoBiz {
    /**
     * 添加app
     * @param appInfo
     * @return
     */
    int addAppInfo(AppInfo appInfo, Keyword keyword);
}
