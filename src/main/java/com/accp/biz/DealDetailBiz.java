package com.accp.biz;

import com.accp.entity.DealDetail;
import com.accp.entity.Page;

import java.util.List;

public interface DealDetailBiz {
    //查看账户明细
    Page<DealDetail> queryDealDetails(int userid, int pageSize, int pageNo);

    /**
     * 通过日期查询代理商的流水明细
     * @param type 0为查询代理商 预付款流水明细即为代理商冻结资金明细
     *              1为查询代理商所有流水明细
     * @param starttime
     * @param endtime
     * @return
     */
    public List<DealDetail> queryDealDetailByDate(int type,String starttime,String endtime);

    Page<DealDetail> queryListByParam(int userid,int dealType,String starttime,String endtime,int pageSize, int pageNo);

    //添加明细
    boolean addDealDetail(DealDetail dealDetail);
}
