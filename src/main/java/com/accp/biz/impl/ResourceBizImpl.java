package com.accp.biz.impl;

import com.accp.biz.ResourceBiz;

import com.accp.dao.ResourceDao;
import com.accp.entity.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(propagation = Propagation.REQUIRED,timeout = 30,rollbackFor = {RuntimeException.class,Exception.class})
    public boolean deleteResourceByRoleId(int roleid) throws Exception{
        if (resourceDao.deleteResourceByRoleId(roleid)>0){
            return true;
        }
        throw new Exception("删除角色资源异常!");
    }

    @Transactional(propagation = Propagation.REQUIRED,timeout = 30,rollbackFor = {RuntimeException.class,Exception.class})
    public boolean addResourceByRoleId(int roleId, int resourceId) throws Exception{
        if (resourceDao.addResourceByRoleId(roleId,resourceId)>0){
            return true;
        }
        throw new Exception("添加角色资源异常!");


    }
}
