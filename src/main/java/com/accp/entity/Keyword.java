package com.accp.entity;

import java.util.Date;

/**
 * 关键字类
 */
public class Keyword {
    private int keywordId;              //关键字id
    private String keyword;             //关键字名
    private int customerId;         //客户id
    private int userId;         //用户id
    private int  term;          //申请年限
    private int typeId;         //服务类别对应字典表
    private Date createTime;        //申请时间
    private int keywordStatus;      //状态

    private UserInfo user;      //关键字的代理商id

    public int getKeywordId() {
        return keywordId;
    }

    public void setKeywordId(int keywordId) {
        this.keywordId = keywordId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getKeywordStatus() {
        return keywordStatus;
    }

    public void setKeywordStatus(int keywordStatus) {
        this.keywordStatus = keywordStatus;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}
