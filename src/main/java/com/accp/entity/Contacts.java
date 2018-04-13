package com.accp.entity;

/**
 * 联系人类
 */
public class Contacts {
    private int contactsId;                 //联系人id
    private int customerId;                 //客户id
    private String contactsName;            //用户名
    private String contactsTel;             //电话
    private String contactsFax;             //传真
    private String contactsPhone;           //手机
    private String  contactsEmail;          //邮箱
    private String contactsPost;            //职务





    public int getContactsId() {
        return contactsId;
    }

    public void setContactsId(int contactsId) {
        this.contactsId = contactsId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getContactsName() {
        return contactsName;
    }

    public void setContactsName(String contactsName) {
        this.contactsName = contactsName;
    }

    public String getContactsTel() {
        return contactsTel;
    }

    public void setContactsTel(String contactsTel) {
        this.contactsTel = contactsTel;
    }

    public String getContactsFax() {
        return contactsFax;
    }

    public void setContactsFax(String contactsFax) {
        this.contactsFax = contactsFax;
    }

    public String getContactsPhone() {
        return contactsPhone;
    }

    public void setContactsPhone(String contactsPhone) {
        this.contactsPhone = contactsPhone;
    }

    public String getContactsEmail() {
        return contactsEmail;
    }

    public void setContactsEmail(String contactsEmail) {
        this.contactsEmail = contactsEmail;
    }

    public String getContactsPost() {
        return contactsPost;
    }

    public void setContactsPost(String contactsPost) {
        this.contactsPost = contactsPost;
    }
}
