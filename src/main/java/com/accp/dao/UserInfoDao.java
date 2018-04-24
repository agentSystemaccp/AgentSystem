package com.accp.dao;

import com.accp.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


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

    int updateUserInfo(UserInfo userInfo);

    /**
     * 通过日期来查询用户余额信息
     * @param starttime
     * @param endtime
     * @return
     */
    public List<UserInfo> queryAllUserBalance(@Param("starttime") String starttime,@Param("endtime") String endtime);

    /**
     * 查找所有用户
     * @return
     */
    List<UserInfo> queryAllUserInfo();
}
