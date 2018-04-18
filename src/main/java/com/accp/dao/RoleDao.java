package com.accp.dao;

import com.accp.entity.Role;

import java.util.List;

public interface RoleDao {

    /**
     * 根据参数查询角色信息
     * @param role
     * @return
     */
    Role findRoleInfo(Role role);

    /**
     * 查找所有信息
     * @return
     */
    List<Role>  findAllInfo();
}
