package com.accp.biz;

import com.accp.entity.Protal;

import java.util.List;

public interface ProtalBiz {
    /**
     * 通过门户名称和客户名称查询门户集合
     * @param protalName
     * @param customerName
     * @return
     */
    public List<Protal> getProtalList( String keyword,String customerName,int userId);
}
