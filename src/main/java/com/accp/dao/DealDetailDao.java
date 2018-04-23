package com.accp.dao;

import com.accp.entity.DealDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DealDetailDao {
    //查看用户明细
    List<DealDetail> queryDealDetails(@Param("userid")int userid, @Param("offset") int offset, @Param("pageSize") int pageSize);

    int queryDealDetailCount(int userid);

    //添加明细
    int addDealDetail(DealDetail dealDetail);

    /**
     * 通过日期查询代理商的流水明细
     * @param type 0为查询代理商 预付款流水明细即为代理商冻结资金明细
     *              1为查询代理商所有流水明细
     * @param starttime
     * @param endtime
     * @return
     */
    public List<DealDetail> queryDealDetailByDate(@Param("type")int type,@Param("starttime") String starttime,@Param("endtime")String endtime);
}
