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
import java.util.List;

@Controller
@RequestMapping("/protal")
public class ProtalController {

    @Resource
    private ProtalBiz protalBiz;

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

}
