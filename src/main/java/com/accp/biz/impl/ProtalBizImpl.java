package com.accp.biz.impl;

import com.accp.biz.ProtalBiz;
import com.accp.dao.ProtalDao;
import com.accp.entity.Page;
import com.accp.entity.Protal;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProtalBizImpl implements ProtalBiz{

    @Resource
    private ProtalDao protalDao;

    public void queryProtalList(String keyword, String customerName, int userId, Page<Protal> protalPage) {
        int totalRows = protalDao.queryProtalCount(keyword,customerName,userId);
        protalPage.setTotalRows(totalRows);
        int totalPage = totalRows % protalPage.getPageSize() == 0?totalRows % protalPage.getPageSize():
                totalRows / protalPage.getPageSize() +1;
        protalPage.setTotalPage(totalPage);
        protalPage.setPageList(protalDao.queryProtalList(keyword,customerName,userId,protalPage));
    }
}

