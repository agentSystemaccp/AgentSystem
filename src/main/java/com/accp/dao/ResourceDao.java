package com.accp.dao;

import com.accp.entity.Menu;
import com.accp.entity.Resource;
import com.accp.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResourceDao {
    /**
     * 根据参数查询信息
     * @param resource
     * @return
     */
    Resource findResourceInfo(Resource resource);

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
    int deleteResourceByRoleId(int roleid);

    /**
     * 根据角色id插入权限数据到中间表
     * @param roleId
     * @param resourceId
     * @return
     */
    int addResourceByRoleId(@Param("roleId") int roleId,@Param("resourceId") int resourceId);
}
