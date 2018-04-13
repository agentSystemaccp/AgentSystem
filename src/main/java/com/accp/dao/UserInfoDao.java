package com.accp.dao;

import com.accp.entity.UserInfo;


public interface UserInfoDao {

    //登录
    UserInfo login(UserInfo userInfo);

    /**
     * 修改密码
     * @return
     */
    int updatePassword(UserInfo userInfo);

    /**
     * 根据参数查询信息
     * @return
     */
    UserInfo findInfo(UserInfo userInfo);

}
