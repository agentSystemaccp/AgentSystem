package com.accp.controller;

import com.accp.biz.DealDetailBiz;
import com.accp.biz.TypeBiz;
import com.accp.biz.UserInfoBiz;
import com.accp.dao.DealDetailDao;
import com.accp.entity.DealDetail;
import com.accp.entity.Type;
import com.accp.entity.UserInfo;
import com.accp.util.ExportFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
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
        model.addAttribute("starttime",starttime);
        model.addAttribute("endtime",endtime);
        return "reportManage";
    }

    /**
     * 导出代理商余额Excel报表
     * @param starttime
     * @param endtime
     * @return
     */
    @RequestMapping("/reportAccountExcel")
    @ResponseBody
    public String reportAccountExcel( String starttime,String endtime){
        List<UserInfo> userInfoList = userInfoBiz.queryAllUserBalance(starttime, endtime);
        String headers[] = {"序号","代理商名称","账户余额"};   //各列列名
        try {
            ExportFile.ExportExcel("代理商余额报表","代理商余额报表",headers,userInfoList);
            return  "1";
        } catch (IOException e) {
            e.printStackTrace();
            return  "2";
        }
    }

    /**
     * 导出代理商预付款流水Excel报表
     * @param starttime
     * @param endtime
     * @return
     */
    @RequestMapping("/reportYFExcel")
    @ResponseBody
    public String reportYFExcel( String starttime,String endtime){
        List<DealDetail> dealDetailList = dealDetailBiz.queryDealDetailByDate(0,starttime,endtime);
        String headers[] = {"序号","代理商名称","预付款","账户余额","备注信息","时间"};   //各列列名
        try {
            ExportFile.ExportExcel("预付款流水报表","预付款流水报表",headers,dealDetailList);
            return  "1";
        } catch (IOException e) {
            e.printStackTrace();
            return  "2";
        }
    }

    /**
     * 导出代理商流水报表Excel报表
     * @param starttime
     * @param endtime
     * @return
     */
    @RequestMapping("/reportUserExcel")
    @ResponseBody
    public String reportUserExcel( String starttime,String endtime){
        List<DealDetail> dealDetailList = dealDetailBiz.queryDealDetailByDate(1,starttime,endtime);
        String headers[] = {"序号","代理商名称","预付款","账户余额","备注信息","时间"};   //各列列名
        try {
            ExportFile.ExportExcel("代理商流水报表","代理商流水报表",headers,dealDetailList);
            return  "1";
        } catch (IOException e) {
            e.printStackTrace();
            return  "2";
        }
    }

    /**
     * 导出产品分类数量金额汇总Excel报表
     * @return
     */
    @RequestMapping("/reportProductExcel")
    @ResponseBody
    public String reportProductExcel(){
        List<Type> typeList = typeBiz.queryProductType();
        String headers[] = {"序号","产品分类名称","数量","价格"};   //各列列名
        try {
            ExportFile.ExportExcel("产品分类数量金额汇总","产品分类数量金额汇总",headers,typeList);
            return  "1";
        } catch (IOException e) {
            e.printStackTrace();
            return  "2";
        }
    }

    /**
     * 导出数据预付款流水PDF报表
     * @param starttime
     * @param endtime
     * @return
     */
    @RequestMapping("/reportYFPDF")
    @ResponseBody
    public String reportYFPDF(String starttime,String endtime){
        List<DealDetail> dealDetailList = dealDetailBiz.queryDealDetailByDate(0,starttime,endtime);
        String headers[] = {"序号","代理商名称","预付款","账户余额","备注信息","时间"};  //各列列名
        try {
            ExportFile.ExportPDF("预付款流水报表","预付款流水报表",headers,dealDetailList);
            return  "1";
        } catch (Exception e) {
            e.printStackTrace();
            return  "2";
        }
    }

    /**
     * 导出代理商流水报表PDF报表
     * @param starttime
     * @param endtime
     * @return
     */
    @RequestMapping("/reportUserPDF")
    @ResponseBody
    public String reportUserPDF(String starttime,String endtime){
        List<DealDetail> dealDetailList = dealDetailBiz.queryDealDetailByDate(1,starttime,endtime);
        String headers[] = {"序号","代理商名称","预付款","账户余额","备注信息","时间"};  //各列列名
        try {
            ExportFile.ExportPDF("代理商流水报表","代理商流水报表",headers,dealDetailList);
            return  "1";
        } catch (Exception e) {
            e.printStackTrace();
            return  "2";
        }
    }

    /**
     * 导出产品分类数量金额汇总PDF报表
     * @param starttime
     * @param endtime
     * @return
     */
    @RequestMapping("/reportProductPDF")
    @ResponseBody
    public String reportProductPDF(String starttime,String endtime){
        List<Type> typeList = typeBiz.queryProductType();
        String headers[] = {"序号","产品分类名称","数量","价格"};   //各列列名
        try {
            ExportFile.ExportPDF("产品分类数量金额汇总","产品分类数量金额汇总",headers,typeList);
            return  "1";
        } catch (Exception e) {
            e.printStackTrace();
            return  "2";
        }
    }

    /**
     * 导出代理商余额报表PDF报表
     * @return
     */
    @RequestMapping("/reportAccountPDF")
    @ResponseBody
    public String reportAccountPDF(String starttime,String endtime){
        List<UserInfo> userInfoList = userInfoBiz.queryAllUserBalance(starttime, endtime);
        String headers[] = {"序号","代理商名称","账户余额"};   //各列列名
        try {
            ExportFile.ExportPDF("代理商余额报表","代理商余额报表",headers,userInfoList);
            return  "1";
        } catch (Exception e) {
            e.printStackTrace();
            return  "2";
        }
    }
}
