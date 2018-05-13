package com.accp.biz.impl;

import com.accp.biz.AppInfoBiz;
import com.accp.dao.AppInfoDao;
import com.accp.dao.KeyWordDao;
import com.accp.entity.AppInfo;
import com.accp.entity.Keyword;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(propagation = Propagation.REQUIRED,timeout = 30,rollbackFor = {RuntimeException.class,Exception.class})
    public int addAppInfo(AppInfo appInfo, Keyword keyword) throws Exception{
        //修改开通状态
        if(keyWordDao.updateKeyWord(keyword)>0){
            if( appInfoDao.addAppInfo(appInfo)>0){
                return 1;
            }
        }
            throw new RuntimeException("关键词或APP更新失败!");
        }

    }

