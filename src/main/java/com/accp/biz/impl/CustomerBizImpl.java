package com.accp.biz.impl;

import com.accp.biz.CustomerBiz;
import com.accp.dao.ContactsDao;
import com.accp.dao.CustomerDao;
import com.accp.dao.ProtalDao;
import com.accp.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(propagation = Propagation.REQUIRED,timeout = 30,rollbackFor = {RuntimeException.class,Exception.class})
    public int updateCustomer(Customer customer) throws Exception {
        if(customerDao.updateCustomer(customer)>0){
            return 1;
        }
        throw new RuntimeException("更新客户失败!");
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
    @Transactional(propagation = Propagation.REQUIRED,timeout = 30,rollbackFor = {RuntimeException.class,Exception.class})
    public int addCustomer(Customer customer, Protal protal) throws Exception{
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
                        if(result<1){
                            throw new RuntimeException("添加联系人失败!");
                        }
                    }
                }

            }else {
                throw new RuntimeException("添加门户失败!");
            }
        }else {
            throw new RuntimeException("添加客户失败!");

        }
        return result;
    }

    /**
     * 修改客户和门户
     * @param customer
     * @param protal
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED,timeout = 30,rollbackFor = {RuntimeException.class,Exception.class})
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
                        if(c.getContactsId()!=0){
                            result=contactsDao.updateContacts(c);       //修改
                        }else {
                            result=contactsDao.addContacts(c);       //增加
                        }
                        if(result<1){
                            throw new RuntimeException("修改或添加联系人失败!");
                        }
                    }
                }

            }else {
                throw new RuntimeException("修改门户失败!");
            }
        }else {
            throw new RuntimeException("修改客户失败!");
        }
        return result;
    }
}
