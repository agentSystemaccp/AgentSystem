package com.accp.biz;

import com.accp.entity.Type;

import java.util.List;

public interface TypeBiz {
    /**
     * 根据父级id拿数据
     * @param parentId
     * @return
     */
    List<Type> queryTypeByParentId(int parentId);

    /**
     * 查询产品类型
     * @return
     */
    List<Type> queryProductType();
}
