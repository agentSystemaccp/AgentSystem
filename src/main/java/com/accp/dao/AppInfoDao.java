package com.accp.dao;

import com.accp.entity.AppInfo;

public interface AppInfoDao {

    /**
     * 修改APP信息
     * @param appInfo
     * @return
     */
    public int updateAppInfo(AppInfo appInfo);

    /**
     * 添加app信息
     * @param appInfo
     * @return
     */
    int addAppInfo(AppInfo appInfo);
}
