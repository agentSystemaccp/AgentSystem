package com.accp.biz.impl;

import com.accp.biz.ProtalBiz;
import com.accp.dao.ProtalDao;
import com.accp.entity.Protal;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProtalBizImpl implements ProtalBiz{

    @Resource
    private ProtalDao protalDao;

    public List<Protal> getProtalList(String keyword, String customerName, int userId) {
        return protalDao.getProtalList(keyword,customerName,userId);
    }
}
