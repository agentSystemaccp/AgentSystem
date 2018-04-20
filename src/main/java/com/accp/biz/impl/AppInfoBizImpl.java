package com.accp.biz.impl;

import com.accp.biz.AppInfoBiz;
import com.accp.dao.AppInfoDao;
import com.accp.dao.KeyWordDao;
import com.accp.entity.AppInfo;
import com.accp.entity.Keyword;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.Key;

@Service
public class AppInfoBizImpl implements AppInfoBiz {


    @Resource
    private AppInfoDao appInfoDao;
    @Resource
    private KeyWordDao keyWordDao;



    /**
     * 添加app
     * @param appInfo
     * @return
     */
    public int addAppInfo(AppInfo appInfo, Keyword keyword) {

        //修改开通状态
        if(keyWordDao.updateKeyWord(keyword)>0){
            return appInfoDao.addAppInfo(appInfo);
        }
        return 0;
    }
}
