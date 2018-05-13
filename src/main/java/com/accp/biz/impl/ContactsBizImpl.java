package com.accp.biz.impl;

import com.accp.biz.ContactsBiz;
import com.accp.dao.ContactsDao;
import com.accp.entity.Contacts;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * 删除联系人
     * @param contactsId
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED,timeout = 30,rollbackFor = {RuntimeException.class,Exception.class})
    public int delContactsById(int contactsId) throws Exception {
        if(contactsDao.delContactsById(contactsId)>0){
            return 1;
        }
        throw new RuntimeException("删除联系人失败!");
    }
}
