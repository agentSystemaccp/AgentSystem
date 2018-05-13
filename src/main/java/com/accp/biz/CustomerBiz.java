package com.accp.biz;

import com.accp.entity.Contacts;
import com.accp.entity.Customer;
import com.accp.entity.Page;
import com.accp.entity.Protal;

import java.util.List;

public interface CustomerBiz {
    //输入框输入搜索客户
    Page queryCustomByList(String companyName, int userId, int pageSize, int pageNo);

    List<Customer> queryCustomBySearch(Customer customer);
//    修改客户
    int updateCustomer(Customer customer) throws Exception;

    Customer queryCustomerByParam(Customer customer);

    int addCustomer(Customer customer, Protal protal) throws Exception;

    //修改客户和门户
    int updateCustomerAndProtal(Customer customer, Protal protal) throws Exception;
}
