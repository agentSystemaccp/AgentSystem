package com.accp.dao;

import com.accp.entity.Menu;
import com.accp.entity.Resource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuDao {

    /**
     * 根据主菜单对象查询其子菜单
     *
     * @return
     */
    List<Resource> findResourceList(@Param("menuId") int menuId,@Param("roleId") int roleId);
}
