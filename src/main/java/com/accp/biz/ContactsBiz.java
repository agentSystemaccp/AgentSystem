package com.accp.biz;

import com.accp.entity.Contacts;

import java.util.List;

public interface ContactsBiz {
    List<Contacts> queryContactsById(int customerId);
}
