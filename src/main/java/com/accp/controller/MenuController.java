package com.accp.controller;

import com.accp.biz.MenuBiz;
import com.accp.entity.Menu;
import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value="/menu")
public class MenuController{
    @Resource(name = "menuBiz")
    private MenuBiz menuBiz;

    @RequestMapping(value = "/manage/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String getFunctionList(@PathVariable String id
    ){
        String [] ids=id.split(",");
        String menuid=ids[0];
        int menu_id=0;
        if (menuid!=null && !menuid.equals("")){
            menu_id=Integer.parseInt(menuid);
        }
        String roleid=ids[1];
        int roleId=0;
        if (roleid!=null && !roleid.equals("")){
            roleId=Integer.parseInt(roleid);
        }
        List<com.accp.entity.Resource> resourceList=menuBiz.findResourceList(menu_id,roleId);
        return JSONArray.toJSONString(resourceList);
    }
}
