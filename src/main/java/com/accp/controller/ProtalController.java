package com.accp.controller;

import com.accp.biz.ProtalBiz;
import com.accp.entity.AppInfo;
import com.accp.entity.Page;
import com.accp.entity.Protal;
import com.accp.entity.UserInfo;
import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;

/**
 * 门户管理层
 */
@Controller
@RequestMapping("/protal")
public class ProtalController {

    @Resource
    private ProtalBiz protalBiz;

    //获取门户集合跳转到门户页面
    @RequestMapping("/queryProtalList")
    public String queryProtalList(@RequestParam(value = "keyword",required = false)String keyword,
                                @RequestParam(value = "companyName",required = false)String companyName,
                                @RequestParam(value = "pageNo",required = false)String pageNo,
                                HttpSession session, Model model){
        UserInfo user = (UserInfo) session.getAttribute("userLogin");
        if(pageNo == null){
            pageNo = "1";
        }
        Page<Protal> protalPage = new Page<Protal>();
        protalPage.setPageNo(Integer.valueOf(pageNo));
        protalPage.setPageSize(5);
        protalBiz.queryProtalList(keyword, companyName, user.getUserid(),protalPage);
        model.addAttribute("page",protalPage);
        model.addAttribute("companyName",companyName);
        model.addAttribute("keyword",keyword);
        return "protalManage";
    }

    //获取门户对象 跳转到门户详情页面
    @RequestMapping("/queryProtal")
    public String queryProtal(int protalId,String cid,String type,Model model) {
        if(cid==null||cid.equals("")){
           cid="0";
        }
        Protal protal = protalBiz.queryProtalById(protalId,Integer.parseInt(cid));
        Date endDate = protal.getCustomer().getKeyword().getCreateTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(endDate);
        calendar.add(Calendar.YEAR, +protal.getCustomer().getKeyword().getTerm());
        endDate = calendar.getTime();
        model.addAttribute("protal", protal);
        model.addAttribute("endDate", endDate);
        if (type.equals("view")) {
            return "viewCustomer";
        } else {
            return "modifyProtal";
        }
    }

    @RequestMapping("/modifyProtal")
    @ResponseBody
    public Object modifyProtal(AppInfo appInfo){
        int result = protalBiz.modifyProtal(appInfo);
        return JSONArray.toJSONString(result);
    }
}
