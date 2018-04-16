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
        int menu_id=0;
        if (id!=null && !id.equals("")){
            menu_id=Integer.parseInt(id);
        }
        //String jspName=allUrl.substring(allUrl.lastIndexOf("/")+1);
        Menu menu=new Menu();
        menu.setMenu_id(menu_id);
        List<com.accp.entity.Resource> resourceList=menuBiz.findResourceList(menu);
        //model.addAttribute("resourceList",resourceList);
        return JSONArray.toJSONString(resourceList);
    }
}
