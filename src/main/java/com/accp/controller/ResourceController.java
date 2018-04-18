package com.accp.controller;

import com.accp.biz.RoleBiz;
import com.accp.entity.Role;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色权限管理控制器
 */
@Controller
@RequestMapping("/role")
public class ResourceController {
    @Resource(name = "roleBiz")
    private RoleBiz roleBiz;

    @RequestMapping("/roleList")
    public String showRoleList(Model model){
        List<Role> roleList=roleBiz.findAllInfo();
        model.addAttribute("roleList",roleList);
        return "permission";
    }


}
