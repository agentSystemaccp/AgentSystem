package com.accp.controller;

import com.accp.biz.DealDetailBiz;
import com.accp.entity.DealDetail;
import com.accp.entity.Page;
import com.accp.entity.UserInfo;
import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(value = "deal")
public class DealDetailController {

    @Resource
    private DealDetailBiz dealDetailBiz;


    /**
     * 返回账单详细page对象
     * @param pageIndex
     * @param session
     * @return
     */

    @PostMapping("/accountdetail")
    @ResponseBody
    public Object accountDetail( HttpSession session,@RequestParam(value = "pageIndex",required = false) String pageIndex){
                int uid = ((UserInfo)session.getAttribute("userLogin")).getUserid();

        if(pageIndex==null||pageIndex==""){
            pageIndex="1";
        }
        Page<DealDetail> page = dealDetailBiz.queryDealDetails(uid,2,Integer.parseInt(pageIndex));

        return JSONArray.toJSONString(page);

    }


    /**
     * 空跳至账户详细信息页面
     * @return
     */
    @RequestMapping("/toAccountDetail")
    public String toAccountDetail(){
        return "dealDetail";
    }

}
