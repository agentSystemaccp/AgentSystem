package com.accp.controller;


import com.accp.biz.UserInfoBiz;
import com.accp.entity.UserInfo;
import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value="/user")
public class UserInfoController {

    @Resource
    private UserInfoBiz userInfoBiz;


    @RequestMapping("/login")
    @ResponseBody
    public Object login(UserInfo userInfo,HttpSession session){
        //登录并返回用户对象
        UserInfo userLogin = userInfoBiz.login(userInfo);

        if(userLogin==null){
            return "0";
        }
        session.setAttribute("userLogin",userLogin);
        return "1";
    }




    /**
     * 动态验证旧密码
     * @return
     */
    @RequestMapping("/vlidatePassword")
    @ResponseBody
    public Object vlidatePassword(String oldpwd, HttpSession session){
        UserInfo userInfo = (UserInfo)session.getAttribute("userLogin");
        //密码正确
        if(userInfo.getUserPassword().equals(oldpwd)){
            return "1";
        }
        return "0";
    }

    /**
     * 修改密码
     * @return
     */
    @RequestMapping("/modifypwd")
    @ResponseBody
    public String updatePassword(String newpwd,HttpSession session) {
        UserInfo userInfo = (UserInfo)session.getAttribute("userLogin");
        userInfo.setUserPassword(newpwd);

        //执行修改
        if(userInfoBiz.updatePassword(userInfo)>0){
            return "1";
        }
        return "0";
    }

    /**
     * 退出
     * @return
     */
    @RequestMapping("/exit")
    public String Exit(HttpSession session){
       //注销登录用户
       session.removeAttribute("userLogin");
       return "redirect:../login.jsp";
    }


    //空跳至代理商管理页面
    @GetMapping("/toManage")
    public String toManage(){
        return "manage";
    }

    /**
     * 财务管理显示用户名
     * @return
     */
    @RequestMapping(value = "/showUserName")
    @ResponseBody
    public String showAllUserName(){
        List<UserInfo> userInfoList=userInfoBiz.queryAllUserInfo();
        return JSONArray.toJSONString(userInfoList);
    }
}
