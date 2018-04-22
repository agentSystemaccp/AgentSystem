package com.accp.biz.impl;

import com.accp.biz.CustomerBiz;
import com.accp.dao.CustomerDao;
import com.accp.entity.Customer;
import com.accp.entity.Keyword;
import com.accp.entity.Page;
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
    public Page queryCustomByList(String companyName,int userId,int pageSize, int pageNo) {
        Page<Customer> page = new Page<Customer>();
        page.setPageSize(pageSize);
        page.setPageNo(pageNo);
        //有问题
        page.setTotalRows(customerDao.queryCountByName(userId,companyName));
        //设置总页数
        page.setTotalPage((page.getTotalRows()+pageSize-1)/pageSize);
        //设置查询的集合
        page.setPageList(customerDao.queryCustomByList(companyName,userId,(pageNo-1)*pageSize,pageSize));
        return page;
    }

    /**
     * 文本框点击搜索客户
     * @param customer
     * @return
     */
    public List<Customer> queryCustomBySearch(Customer customer) {
        return customerDao.queryCustomBySearch(customer);
    }


    /**
     * 修改客户
     * @param customer
     * @return
     */
    public int updateCustomer(Customer customer) {
        return customerDao.updateCustomer(customer);
    }
}
