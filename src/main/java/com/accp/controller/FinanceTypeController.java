package com.accp.controller;

import com.accp.biz.FinanceTypeBiz;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping(value="/financeType")
public class FinanceTypeController {
    @Resource(name = "financeTypeBiz")
    private FinanceTypeBiz financeTypeBiz;

    @RequestMapping("/show")
    public String showCaiwuType(){
        return "";
    }
}
