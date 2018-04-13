package com.accp.dao;

import com.accp.entity.Menu;
import com.accp.entity.Resource;

import java.util.List;

public interface MenuDao {

    /**
     * 根据主菜单对象查询其子菜单
     * @param menu
     * @return
     */
    List<Resource> findResourceList(Menu menu);
}
