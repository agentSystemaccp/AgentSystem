package com.accp.biz.impl;

import com.accp.biz.UserInfoBiz;
import com.accp.dao.ResourceDao;
import com.accp.dao.RoleDao;
import com.accp.dao.UserInfoDao;
import com.accp.entity.Role;
import com.accp.entity.UserInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("userInfoBiz")
public class UserInfoBizImpl implements UserInfoBiz {

    @Resource(name = "userInfoDao")
    private UserInfoDao userInfoDao;
    @Resource(name = "resourceDao")
    private ResourceDao resourceDao;
    @Resource(name = "roleDao")
    private RoleDao roleDao;

    /**
     * 登录验证
     * @param userInfo
     * @return
     */
    public UserInfo login(UserInfo userInfo) {
        userInfo=userInfoDao.login(userInfo);
        Role role=new Role();
        role.setRoleId(userInfo.getRoleId());
        Role role1=roleDao.findRoleInfo(role);      //查找角色权限信息
        userInfo .setRole(role1);
        return userInfo;
    }


    /**
     *  修改密码
     * @param userInfo
     * @return
     */
    public int updatePassword(UserInfo userInfo) {
        return userInfoDao.updatePassword(userInfo);
    }
}