package com.accp.biz;

import com.accp.entity.Menu;
import com.accp.entity.Resource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuBiz {
    /**
     * 根据主菜单对象查询其子菜单
     * @return
     */
    List<Resource> findResourceList(int menuId,int roleId);
}
