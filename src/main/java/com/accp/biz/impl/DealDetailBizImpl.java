package com.accp.biz.impl;

import com.accp.biz.DealDetailBiz;
import com.accp.dao.DealDetailDao;
import com.accp.entity.DealDetail;
import com.accp.entity.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    public List<DealDetail> queryDealDetailByDate(int type,String starttime, String endtime) {
        return dealDetailDao.queryDealDetailByDate(type,starttime,endtime);
    }

    /**
     * 预付款列表
     * @param userid
     * @param dealType
     * @param starttime
     * @param endtime
     * @param pageSize
     * @param pageNo
     * @return
     */
    public Page<DealDetail> queryListByParam(int userid, int dealType, String starttime, String endtime, int pageSize, int pageNo) {
        Page<DealDetail> page = new Page<DealDetail>();
        page.setPageSize(pageSize);
        page.setPageNo(pageNo);
        page.setTotalRows(dealDetailDao.queryListCount(userid,dealType,starttime,endtime));
        //设置总页数
        page.setTotalPage((page.getTotalRows()+pageSize-1)/pageSize);
        //设置查询的集合
        page.setPageList(dealDetailDao.queryListByParam(userid,dealType,starttime,endtime,(pageNo-1)*pageSize,pageSize));
        return page;
    }

    /**
     * 添加一条明细
     * @param dealDetail
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED,timeout = 30,rollbackFor = {RuntimeException.class,Exception.class})
    public boolean addDealDetail(DealDetail dealDetail) throws Exception{
        if (dealDetailDao.addDealDetail(dealDetail)>0){
            return true;
        }
        throw new RuntimeException("添加明细异常!");
    }
}
