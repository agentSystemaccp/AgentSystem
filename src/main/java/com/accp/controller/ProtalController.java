package com.accp.controller;

import com.accp.biz.ProtalBiz;
import com.accp.entity.Page;
import com.accp.entity.Protal;
import com.accp.entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;

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
    public String queryProtal(int protalId,String type,Model model) {
        Protal protal = protalBiz.queryProtalById(protalId);
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
}
