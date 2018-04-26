package com.accp.dao;

import com.accp.entity.FinanceType;

import java.util.List;

public interface FinanceTypeDao {
    /**
     * 根据父类ID查询类型
     * @param parentId
     * @return
     */
    List<FinanceType> findTypeByParentId(int parentId);
}
