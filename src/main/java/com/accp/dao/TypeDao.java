package com.accp.dao;

import com.accp.entity.Type;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TypeDao {

    /**
     * 根据父级id拿数据
     * @param parentId
     * @return
     */
    List<Type> queryTypeByParentId(int parentId);
}
