package com.accp.dao;

import com.accp.entity.Page;
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
    public List<Protal> queryProtalList(@Param("keyword") String keyword
            , @Param("customerName")String customerName, @Param("userId")int userId
            , @Param("page") Page<Protal> protalPage);

    /**
     * 获取门户的总数量
     * @return
     */
    public int queryProtalCount(@Param("keyword") String keyword
            , @Param("customerName")String customerName,@Param("userId") int userId);
}
