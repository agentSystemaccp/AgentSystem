package com.accp.biz.impl;

import com.accp.biz.ProtalBiz;
import com.accp.dao.ContactsDao;
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

    @Resource
    private ContactsDao contactsDao;

    /**
     * 通过门户名称和客户名称查询门户集合
     * @param keyword
     * @param customerName
     * @return
     */
    public void queryProtalList(String keyword, String customerName, int userId, Page<Protal> protalPage) {
        int totalRows = protalDao.queryProtalCount(keyword,customerName,userId);
        protalPage.setTotalRows(totalRows);
        protalPage.setTotalPage(totalRows % protalPage.getPageSize() == 0?totalRows % protalPage.getPageSize():
                totalRows / protalPage.getPageSize() +1);
        protalPage.setPageList(protalDao.queryProtalList(keyword,customerName,userId,
                (protalPage.getPageNo()-1)*protalPage.getPageSize(),protalPage.getPageSize()));
    }
    /**
     * 通过门户id查询门户机器关联的客户和联系人
     * @param protalId
     * @return
     */
    public Protal queryProtalById(int protalId) {
        Protal protal = protalDao.queryProtalById(protalId);
        protal.getCustomer().setContacts(contactsDao.queryContactsByCustomerId(protal.getCustomerId()));
        return protal;
    }
}

