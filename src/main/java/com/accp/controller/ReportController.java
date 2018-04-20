package com.accp.controller;

import com.accp.biz.UserInfoBiz;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * 报表控制层
 */

@Controller
@RequestMapping("/report")
public class ReportController {

    @Resource
    private UserInfoBiz userInfoBiz;

    /**
     * 空跳到报表管理页面
     * @return
     */
    @RequestMapping("/queryReportManage")
    public String queryReportManage(@RequestParam(value = "reportType",required = false)String reportType,
                                    @RequestParam(value = "starttime",required = false)String starttime,
                                    @RequestParam(value = "endtime",required = false)String endtime,
                                    Model model){

        return "reportManage";
    }
}
