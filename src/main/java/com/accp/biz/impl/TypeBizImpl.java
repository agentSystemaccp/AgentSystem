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
    public List<Type> queryTypeByParentId(int parentId,int status) {
        return typeDao.queryTypeByParentId(parentId,status);
    }

    /**
     * 查询产品类型
     * @return
     */
    public List<Type> queryProductType() {
        return typeDao.queryProductType();
    }

    /**
     * 通过Id删除类型
     * @param typeId
     * @return
     */
    public int delType(int typeId) {
        return typeDao.delType(typeId);
    }

    /**
     * 添加类型
     * @param type
     * @return
     */
    public int addType(Type type){
        return typeDao.addType(type);
    }

    /**
     * 通过类型名称查询类型
     * @param typeName
     * @return
     */
    public Type queryTypeByName(String typeName) {
        return typeDao.queryTypeByName(typeName);
    }

    /**
     * 修改类型
     * @param type
     * @return
     */
    public int updateType(Type type) {
        return typeDao.updateType(type);
    }
}
