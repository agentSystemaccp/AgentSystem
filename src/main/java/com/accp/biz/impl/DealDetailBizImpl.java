package com.accp.biz.impl;

import com.accp.biz.DealDetailBiz;
import com.accp.dao.DealDetailDao;
import com.accp.entity.DealDetail;
import com.accp.entity.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class DealDetailBizImpl implements DealDetailBiz {

    @Resource
    private DealDetailDao dealDetailDao;

    /**
     * 查看用户明细
     * @param userid
     * @return
     */
    public Page<DealDetail> queryDealDetails(int userid, int pageSize, int pageNo) {
        Page<DealDetail> page = new Page<DealDetail>();
        page.setPageSize(pageSize);
        page.setPageNo(pageNo);
        page.setTotalRows(dealDetailDao.queryDealDetailCount(userid));
        //设置总页数
        page.setTotalPage((page.getTotalRows()+pageSize-1)/pageSize);
        //设置查询的集合
        page.setPageList(dealDetailDao.queryDealDetails(userid,(pageNo-1)*pageSize,pageSize));
        return page;
    }

}
