package com.accp.controller;

import com.accp.biz.DealDetailBiz;
import com.accp.biz.TypeBiz;
import com.accp.biz.UserInfoBiz;
import com.accp.dao.DealDetailDao;
import com.accp.entity.DealDetail;
import com.accp.entity.Type;
import com.accp.entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * 报表控制层
 */

@Controller
@RequestMapping("/report")
public class ReportController {

    @Resource
    private UserInfoBiz userInfoBiz;

    @Resource
    private DealDetailBiz dealDetailBiz;

    @Resource
    private TypeBiz typeBiz;

    /**
     * 跳转到报表管理页面 并通过条件查询相关的数据
     * @param reportType  查询数据类型
     * @param starttime 起始时间
     * @param endtime   结束时间
     * @param model
     * @return
     */
    @RequestMapping("/queryReportManage")
    public String queryReportManage(@RequestParam(value = "reportType",required = false)String reportType,
                                    @RequestParam(value = "starttime",required = false)String starttime,
                                    @RequestParam(value = "endtime",required = false)String endtime,
                                    Model model){
        //查询代理商余额
         if("1".equals(reportType)){
            List<UserInfo> userInfoList = userInfoBiz.queryAllUserBalance(starttime, endtime);
            model.addAttribute("userInfoList",userInfoList);
        }
        //查询代理商预付款明细
        if("2".equals(reportType)){
            List<DealDetail> dealDetailList = dealDetailBiz.queryDealDetailByDate(0,starttime,endtime);;
            model.addAttribute("dealDetailList",dealDetailList);
        }
        //查询代理商所有明细
        if("3".equals(reportType)){
            List<DealDetail> dealDetailList = dealDetailBiz.queryDealDetailByDate(1,starttime,endtime);;
            model.addAttribute("dealDetailList",dealDetailList);
        }
        //查询产品分类并统计金额汇总
        if("4".equals(reportType)){
            List<Type> typeList = typeBiz.queryProductType();
            model.addAttribute(typeList);
        }
        model.addAttribute("reportType",reportType);
        return "reportManage";
    }
}
