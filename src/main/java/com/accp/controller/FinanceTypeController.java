package com.accp.controller;

import com.accp.biz.FinanceTypeBiz;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value="/financeType")
public class FinanceTypeController {
    @Resource(name = "financeTypeBiz")
    private FinanceTypeBiz financeTypeBiz;

    @RequestMapping("/showCaiwuType")
    public String showCaiwuType(Model model){
        return "";
    }
}
