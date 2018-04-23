package com.accp.dao;

import com.accp.entity.Contacts;

import java.util.List;

public interface ContactsDao {
    /**
     * 通过客户id查询客户下的联系人
     * @param customerId
     * @return
     */
    public List<Contacts> queryContactsByCustomerId(int customerId);
    //添加联系人
    int addContacts(Contacts contacts);
}
