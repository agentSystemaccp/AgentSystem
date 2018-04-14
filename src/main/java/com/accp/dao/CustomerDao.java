package com.accp.dao;


import com.accp.entity.Customer;

import java.util.List;

/**
 * 客户dao
 */
public interface CustomerDao {

    //搜索框搜索前十位客户
    List<Customer> queryCustomBySearch(Customer customer);
}
