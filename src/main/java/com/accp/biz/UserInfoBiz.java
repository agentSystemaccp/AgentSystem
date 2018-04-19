package com.accp.biz;

import com.accp.entity.UserInfo;

import java.util.Date;
import java.util.List;

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

    /**
     * 通过日期来查询用户余额信息
     * @param starttime
     * @param endtime
     * @return
     */
    public List<UserInfo> queryAllUserBalance(Date starttime, Date endtime);
}
