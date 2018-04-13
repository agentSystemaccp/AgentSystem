package com.accp.controller;

import com.accp.biz.ProtalBiz;
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

    @RequestMapping("/getProtalList")
    public String getProtalList(@RequestParam(value = "keyword",required = false)String keyword,
                                @RequestParam(value = "companyName",required = false)String companyName,
                                HttpSession session, Model model){
        UserInfo user = (UserInfo) session.getAttribute("userLogin");
        List<Protal> protalList = protalBiz.getProtalList(keyword, companyName, user.getUserid());
        model.addAttribute("protalList",protalList);
        return "protalManage";
    }

}
