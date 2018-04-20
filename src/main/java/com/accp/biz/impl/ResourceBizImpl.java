package com.accp.biz.impl;

import com.accp.biz.ResourceBiz;

import com.accp.dao.ResourceDao;
import com.accp.entity.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("resourceBiz")
public class ResourceBizImpl implements ResourceBiz {
   @Resource(name = "resourceDao")
   private ResourceDao resourceDao;

    public List<com.accp.entity.Resource> findResourceByRole(Role role) {
        return resourceDao.findResourceByRole(role);
    }

    public List<com.accp.entity.Resource> findAllResource() {
        return resourceDao.findAllResource();
    }
}
