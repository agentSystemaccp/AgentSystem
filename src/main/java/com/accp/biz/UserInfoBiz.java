package com.accp.biz;

import com.accp.entity.UserInfo;

public interface UserInfoBiz {

    /**
     * 登录验证
     * @param userInfo
     * @return
     */
    UserInfo login(UserInfo userInfo);

    /**
     * 修改密码
     * @param userInfo
     * @return
     */
    int updatePassword(UserInfo userInfo);
}
