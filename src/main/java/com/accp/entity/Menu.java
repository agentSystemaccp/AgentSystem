package com.accp.entity;

/**
 * 菜单类
 */
public class Menu {
    private int menu_id;  //菜单编号
    private String menuName;  //菜单名称
    private String menuUrl;     //主菜单路径

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }
}
