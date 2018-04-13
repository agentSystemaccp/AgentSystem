package com.accp.dao;

import com.accp.entity.DealDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DealDetailDao {
    //查看用户明细
    List<DealDetail> queryDealDetails(@Param("userid")int userid, @Param("offset") int offset, @Param("pageSize") int pageSize);

    int queryDealDetailCount(int userid);
}
