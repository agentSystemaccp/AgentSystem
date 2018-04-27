package com.accp.biz.impl;

import com.accp.biz.FinanceTypeBiz;
import com.accp.dao.FinanceTypeDao;
import com.accp.entity.FinanceType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("financeTypeBiz")
public class FinanceTypeBizImpl implements FinanceTypeBiz {
    @Resource(name = "financeTypeDao")
    private FinanceTypeDao financeTypeDao;
    public List<FinanceType> findTypeByParentId(int parentId) {

        return financeTypeDao.findTypeByParentId(parentId);
    }
}
