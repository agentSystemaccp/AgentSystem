package com.accp.biz.impl;

import com.accp.biz.RoleBiz;
import com.accp.dao.RoleDao;
import com.accp.entity.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色业务实现类
 */
@Service("roleBiz")
public class RoleBizImpl implements RoleBiz {
    @Resource(name = "roleDao")
    private RoleDao roleDao;

    public List<Role> findAllInfo() {
        return roleDao.findAllInfo();
    }
}
