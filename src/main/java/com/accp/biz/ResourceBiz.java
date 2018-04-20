package com.accp.biz;

import com.accp.entity.Resource;
import com.accp.entity.Role;

import java.util.List;

/**
 * 权限业务类
 */

public interface ResourceBiz {
    /**
     * 根据角色查询其权限
     * @param role
     * @return
     */
    List<Resource> findResourceByRole(Role role);

    /**
     * 查询所有权限
     * @return
     */
    List<Resource> findAllResource();
}
