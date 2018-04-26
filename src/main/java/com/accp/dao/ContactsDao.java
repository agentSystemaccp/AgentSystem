package com.accp.dao;

import com.accp.entity.Contacts;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContactsDao {
    /**
     * 通过客户id查询客户下的联系人
     * @param customerId
     * @return
     */
    public List<Contacts> queryContactsByCustomerId(@Param("customerId") int customerId);
    //添加联系人
    int addContacts(Contacts contacts);

    int updateContacts(Contacts contacts);

    int delContactsById(int contactsId);
}
