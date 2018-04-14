package com.accp.entity;

import java.util.List;

/**
 * 客户
 */
public class Customer {
    private int customerId;     //客户id
    private int userId;     //代理商id
    private String companyName; //企业名
    private int companyType;        //企业类型id
    private String companyPages;    //企业主页
    private int companyStatus;      //状态

    private List<Contacts> contacts;        //客户联系人集合
    private List<Protal> protals;              //客户门户集合
    private Keyword keyword;            //客户下的关键字集合
    private Type type;              //客户类型
    private UserInfo user;          //客户的代理商

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getCompanyType() {
        return companyType;
    }

    public void setCompanyType(int companyType) {
        this.companyType = companyType;
    }

    public String getCompanyPages() {
        return companyPages;
    }

    public void setCompanyPages(String companyPages) {
        this.companyPages = companyPages;
    }

    public int getCompanyStatus() {
        return companyStatus;
    }

    public void setCompanyStatus(int companyStatus) {
        this.companyStatus = companyStatus;
    }

    public List<Contacts> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contacts> contacts) {
        this.contacts = contacts;
    }

    public List<Protal> getProtals() {
        return protals;
    }

    public void setProtals(List<Protal> protals) {
        this.protals = protals;
    }

    public Keyword getKeyword() {
        return keyword;
    }

    public void setKeyword(Keyword keyword) {
        this.keyword = keyword;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

}
