package com.accp.dao;

import com.accp.entity.Protal;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProtalDao {
    /**
     * 通过门户名称和客户名称查询门户集合
     * @param keyword
     * @param customerName
     * @return
     */
    public List<Protal> getProtalList(@Param("keyword") String keyword
            ,@Param("customerName")String customerName,@Param("userId")int userId);
}
