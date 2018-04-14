package com.accp.biz.impl;

import com.accp.biz.CustomerBiz;
import com.accp.dao.CustomerDao;
import com.accp.entity.Customer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerBizImpl implements CustomerBiz {

    @Resource
    private CustomerDao customerDao;

    /**
     * 输入框输入搜索前十位客户
     * @param customer
     * @return
     */
    public List<Customer> queryCustomBySearch(Customer customer) {
        return customerDao.queryCustomBySearch(customer);
    }
}
