package com.accp.biz.impl;

import com.accp.biz.ContactsBiz;
import com.accp.dao.ContactsDao;
import com.accp.entity.Contacts;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ContactsBizImpl implements ContactsBiz {

    @Resource
    private ContactsDao contactsDao;


    /**
     * 根据客户id得到客户的联系人
     * @param customerId
     * @return
     */
    public List<Contacts> queryContactsById(int customerId) {
        return contactsDao.queryContactsByCustomerId(customerId);
    }
}
