package com.accp.entity;

import java.util.Date;

/**
 * 账户明细表
 */
public class DealDetail {
    private int detailId;
    private int userId;        //当前明细对象对应的用户
    private String financeType;        //财务类型
    private float financeFund;      //交易金额
    private float  balance;         //交易时所剩余额
    private Date createTime;          //交易时间
    private String remark;          //备注
    private UserInfo user;      //当前明细用户对象

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFinanceType() {
        return financeType;
    }

    public void setFinanceType(String financeType) {
        this.financeType = financeType;
    }

    public float getFinanceFund() {
        return financeFund;
    }

    public void setFinanceFund(float financeFund) {
        this.financeFund = financeFund;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }
}
