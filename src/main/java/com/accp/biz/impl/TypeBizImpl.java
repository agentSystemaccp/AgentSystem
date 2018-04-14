package com.accp.biz.impl;

import com.accp.biz.TypeBiz;
import com.accp.dao.TypeDao;
import com.accp.entity.Type;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class TypeBizImpl implements TypeBiz {

    @Resource
    private TypeDao typeDao;


    /**
     * 根据父级id拿值
     * @param parentId
     * @return
     */
    public List<Type> queryTypeByParentId(int parentId) {
        return typeDao.queryTypeByParentId(parentId);
    }
}
