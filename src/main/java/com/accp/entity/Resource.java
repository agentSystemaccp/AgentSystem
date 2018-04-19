package com.accp.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Resource {
    private  int resourceId; //资源id
    private  String  resourceName; //资源名
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime; //创建时间
    private  int  resourceStatus;// 状态 1
    private String resourceUrl;     //权限路径
    private  int  menuId;  //菜单id
    private Menu menu;


    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getResourceStatus() {
        return resourceStatus;
    }

    public void setResourceStatus(int resourceStatus) {
        this.resourceStatus = resourceStatus;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }
}
