package com.accp.dao;

import com.accp.entity.Type;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TypeDao {

    /**
     * 根据父级id,和是否启用状态拿数据
     * @param parentId
     * @param status
     * @return
     */
    List<Type> queryTypeByParentId(@Param("parentId") int parentId,@Param("status")int status);

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
    int delType(int typeId);

    /**
     * 添加类型
     * @param type
     * @return
     */
    int addType(Type type);

    /**
     * 通过类型名称查询类型
     * @param typeName
     * @return
     */
    Type queryTypeByName(@Param("typeName") String typeName);

    /**
     * 修改类型
     * @param type
     * @return
     */
    int updateType(Type type);
}
