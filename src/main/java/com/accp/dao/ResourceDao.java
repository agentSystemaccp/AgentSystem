package com.accp.dao;

import com.accp.entity.Menu;
import com.accp.entity.Resource;

import java.util.List;

public interface ResourceDao {
    /**
     * 根据参数查询信息
     * @param resource
     * @return
     */
    Resource findResourceInfo(Resource resource);


}
