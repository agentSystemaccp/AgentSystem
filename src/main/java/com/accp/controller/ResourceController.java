package com.accp.controller;

import com.accp.biz.ResourceBiz;
import com.accp.biz.RoleBiz;
import com.accp.entity.Role;
import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import java.util.List;

/**
 * 角色权限管理控制器
 */
@Controller
@RequestMapping("/resource")
public class ResourceController {
    @Resource(name = "roleBiz")
    private RoleBiz roleBiz;
    @Resource(name = "resourceBiz")
    private ResourceBiz resourceBiz;

    @RequestMapping(value = "/resourceList/{roleId}",method = RequestMethod.GET)
    public String showRoleList(Model model,
                               @PathVariable String roleId){
        int role_id=0;
        if (roleId!=null && !roleId.equals("")){
            role_id=Integer.parseInt(roleId);
        }
        Role role=new Role();
        role.setRoleId(role_id);
        //根据角色查询其下权限
       List<com.accp.entity.Resource> resourceList=resourceBiz.findResourceByRole(role);
        //查询所有权限
        List<com.accp.entity.Resource> resources=resourceBiz.findAllResource();
        for (com.accp.entity.Resource resource:resources ) {
            for (com.accp.entity.Resource re:resourceList){
                if (re.getResourceId()==resource.getResourceId()){
                    //角色有该权限 属性check为true 及被选中
                    resource.setCheck(true);
                    //状态改为1 （启用）
                    resource.setResourceStatus(1);
                }
            }

        }
        model.addAttribute("roleId",role_id);
        model.addAttribute("resources",resources);
        //model.addAttribute("resourceList",resourceList);
        return "functionlist";
    }

    @RequestMapping(value = "/saverolefunc/{roleResource}",method = RequestMethod.POST)
    @ResponseBody
    public Object saveResourceIntoRole(@PathVariable String roleResource){

        //roleResource中第一个角色id  后面是权限resourceId
        String [] resources=roleResource.split(",");
        String roleid=resources[0];
        int roleId=0;
        if (roleid!=null && !roleid.equals("")){
            roleId=Integer.parseInt(roleid);
        }
        int resourceId=0;
        //先删除权限中间表角色的权限
        if (resourceBiz.deleteResourceByRoleId(roleId)){
            //删除成功后，循环遍历重新根据角色ID添加权限
            for (int i=1;i<resources.length;i++){
                if (resources[i]!=null && !resources[i].equals("")){
                    resourceId=Integer.parseInt(resources[i]);
                }
                resourceBiz.addResourceByRoleId(roleId,resourceId);
            }
            return "success";
        }
        return "false";
    }

}
