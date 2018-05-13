package com.accp.biz;

import com.accp.entity.Resource;
import com.accp.entity.Role;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 根据角色ID删除角色权限中间表数据
     * @param roleid
     * @return
     */
    boolean deleteResourceByRoleId(int roleid) throws Exception;

    /**
     * 根据角色id插入权限数据到中间表
     * @param roleId
     * @param resourceId
     * @return
     */
    boolean addResourceByRoleId(int roleId,int resourceId) throws Exception;
}
