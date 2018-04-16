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
            , @Param("pageNo") int pageNo,@Param("pageSize") int pageSize);

    /**
     * 获取门户的总数量
     * @return
     */
    public int queryProtalCount(@Param("keyword") String keyword
            , @Param("customerName")String customerName,@Param("userId") int userId);

    /**
     * 通过门户id查询门户机器关联的客户和联系人
     * @param protalId
     * @return
     */
    public Protal queryProtalById(int protalId);
}
