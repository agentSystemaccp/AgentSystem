package com.accp.dao;

import com.accp.entity.Role;

public interface RoleDao {

    /**
     * 根据参数查询角色信息
     * @param role
     * @return
     */
    Role findRoleInfo(Role role);
}
