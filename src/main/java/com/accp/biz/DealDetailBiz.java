package com.accp.biz;

import com.accp.entity.DealDetail;
import com.accp.entity.Page;

import java.util.List;

public interface DealDetailBiz {
    //查看账户明细
    Page<DealDetail> queryDealDetails(int userid, int pageSize, int pageNo);
}
