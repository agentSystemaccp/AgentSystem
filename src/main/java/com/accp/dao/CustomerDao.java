package com.accp.dao;

import com.accp.entity.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 客户dao
 */
public interface CustomerDao {

    //搜索框搜索前十位客户
    List<Customer> queryCustomByList(@Param("companyName") String companyName,@Param("userId") int userId,@Param("offset") int offset, @Param("pageSize") int pageSize);

    int queryCountByName(@Param("userId")int userId,@Param("companyName") String companyName);


    List<Customer> queryCustomBySearch(Customer customer);
    //修改客户
    int updateCustomer(Customer customer);

    //根据参数返回客户对象
    Customer queryCustomerByParam(Customer customer);
    //添加客户信息
    int addCustomer(Customer customer);


}
