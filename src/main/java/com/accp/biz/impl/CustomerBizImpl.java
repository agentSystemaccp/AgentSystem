package com.accp.biz.impl;

import com.accp.biz.CustomerBiz;
import com.accp.dao.ContactsDao;
import com.accp.dao.CustomerDao;
import com.accp.dao.ProtalDao;
import com.accp.entity.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerBizImpl implements CustomerBiz {

    @Resource
    private CustomerDao customerDao;
    @Resource
    private ProtalDao protalDao;
    @Resource
    private ContactsDao contactsDao;

    /**
     * 输入框输入搜索前十位客户
     * @param
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

    /**
     * 根据参数得到客户
     * @param customer
     * @return
     */
    public Customer queryCustomerByParam(Customer customer) {
        return customerDao.queryCustomerByParam(customer);
    }

    /**
     * 添加客户
     * @param customer
     * @param protal
     * @return
     */
    public int addCustomer(Customer customer, Protal protal) {
        int result = 0;
        int cid=0;
//        1:添加客户
        if((result=customerDao.addCustomer(customer))>0){
            cid = customerDao.queryCustomerByParam(customer).getCustomerId();
            protal.setCustomerId(cid);
            result=-1;
//            2:添加门户
            if((result=protalDao.addProtal(protal))>0){

//                循环添加联系人
                if(customer.getContacts()!=null){
                    for (Contacts c:customer.getContacts()) {
                        result=-1;
                        c.setCustomerId(cid);
                        result=contactsDao.addContacts(c);
                    }
                }

            }
        }
        return result;
    }

    /**
     * 修改客户和门户
     * @param customer
     * @param protal
     * @return
     */
    public int updateCustomerAndProtal(Customer customer, Protal protal) {
        int result = 0;
        int cid=0;
//        1:添加客户
        if((result=customerDao.updateCustomer(customer))>0){
            result=-1;
            cid = customerDao.queryCustomerByParam(customer).getCustomerId();
//            2:添加门户
            if((result=protalDao.updateProtal(protal))>0){

//                循环添加联系人
                if(customer.getContacts()!=null){
                    for (Contacts c:customer.getContacts()) {
                        result=-1;
                        c.setCustomerId(cid);
                        result=contactsDao.updateContacts(c);
                    }
                }

            }
        }
        return result;
    }
}
