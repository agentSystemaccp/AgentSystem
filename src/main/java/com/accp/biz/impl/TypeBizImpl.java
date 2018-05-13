package com.accp.biz.impl;

import com.accp.biz.TypeBiz;
import com.accp.dao.TypeDao;
import com.accp.entity.Type;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(propagation = Propagation.REQUIRED,timeout = 30,rollbackFor = {RuntimeException.class,Exception.class})
    public int delType(int typeId) throws Exception {
        if(typeDao.delType(typeId)>0){
            return 1;
        }
        throw new RuntimeException("删除类型异常!");
    }

    /**
     * 添加类型
     * @param type
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED,timeout = 30,rollbackFor = {RuntimeException.class,Exception.class})
    public int addType(Type type) throws Exception{
        if(typeDao.addType(type)>0){
            return 1;
        }
        throw new RuntimeException("添加类型异常!");
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
    @Transactional(propagation = Propagation.REQUIRED,timeout = 30,rollbackFor = {RuntimeException.class,Exception.class})
    public int updateType(Type type) throws Exception {
        if(typeDao.updateType(type)>0){
            return 1;
        }
        throw new RuntimeException("更新类型异常!");
    }
}
