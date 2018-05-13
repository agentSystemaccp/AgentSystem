package com.accp.biz;

import com.accp.entity.Type;

import java.util.List;

public interface TypeBiz {
    /**
     * 根据父级id拿数据
     * @param parentId
     * @return
     */
    List<Type> queryTypeByParentId(int parentId,int status);

    /**
     * 查询产品类型
     * @return
     */
    List<Type> queryProductType();

    /**
     * 通过Id删除类型
     * @param typeId
     * @return
     */
    int delType(int typeId) throws Exception;

    /**
     * 添加类型
     * @param type
     * @return
     */
    int addType(Type type) throws Exception;

    /**
     * 通过类型名称查询类型
     * @param typeName
     * @return
     */
    Type queryTypeByName(String typeName);

    /**
     * 修改类型
     * @param type
     * @return
     */
    int updateType(Type type) throws Exception;
}
