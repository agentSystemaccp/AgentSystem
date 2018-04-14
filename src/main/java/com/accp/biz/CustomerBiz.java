package com.accp.biz;

import com.accp.entity.Customer;

import java.util.List;

public interface CustomerBiz {
    //输入框输入搜索客户
    List<Customer> queryCustomBySearch(Customer customer);
}
