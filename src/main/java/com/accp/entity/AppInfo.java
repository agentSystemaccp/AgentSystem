package com.accp.entity;

public class AppInfo {
    private int appId;
    private int customerId;
    private String appCode;
    private String appPassword;
    private String appIOSUrl;
    private String appAndroidUrl;
    private String appIOSQRCodeUrl;
    private String appAndroidQRCodeUrl;

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getAppPassword() {
        return appPassword;
    }

    public void setAppPassword(String appPassword) {
        this.appPassword = appPassword;
    }

    public String getAppIOSUrl() {
        return appIOSUrl;
    }

    public void setAppIOSUrl(String appIOSUrl) {
        this.appIOSUrl = appIOSUrl;
    }

    public String getAppAndroidUrl() {
        return appAndroidUrl;
    }

    public void setAppAndroidUrl(String appAndroidUrl) {
        this.appAndroidUrl = appAndroidUrl;
    }

    public String getAppIOSQRCodeUrl() {
        return appIOSQRCodeUrl;
    }

    public void setAppIOSQRCodeUrl(String appIOSQRCodeUrl) {
        this.appIOSQRCodeUrl = appIOSQRCodeUrl;
    }

    public String getAppAndroidQRCodeUrl() {
        return appAndroidQRCodeUrl;
    }

    public void setAppAndroidQRCodeUrl(String appAndroidQRCodeUrl) {
        this.appAndroidQRCodeUrl = appAndroidQRCodeUrl;
    }
}
