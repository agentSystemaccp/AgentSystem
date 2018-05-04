package com.accp.controller;

import com.accp.biz.DealDetailBiz;
import com.accp.biz.UserInfoBiz;
import com.accp.entity.DealDetail;
import com.accp.entity.Page;
import com.accp.entity.UserInfo;
import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;


@Controller
@RequestMapping(value = "/deal")
public class DealDetailController {

    @Resource
    private DealDetailBiz dealDetailBiz;
    @Resource
    private UserInfoBiz userInfoBiz;


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


    /**
     * 添加账户明细
     * @param userId
     * @param money
     * @param detailTypeName
     * @param memo
     * @return
     */
    @RequestMapping("/createAccountDetail")
    @ResponseBody
    public Object createDetail(@RequestParam(value = "userId",required = false) String userId,
                               @RequestParam(value = "money",required = false) String money,
                               @RequestParam(value = "detailTypeName",required = false) String detailTypeName,
                               @RequestParam(value = "userbalance",required = false) String userbalance,
                               @RequestParam(value = "memo",required = false) String memo
    ){
        //用户ID
        int user_Id=0;
        int sum=0;      //输入的资金数
        if (userId!=null && !userId.equals("")){
            user_Id=Integer.parseInt(userId);
        }
        //账户余额
        int balance=0;
        if (userbalance!=null && !userbalance.equals("")){
            balance=Integer.parseInt(userbalance);
        }
        //截取第一个字符 判断资金是正或负
        String sign=money.substring(0,1);
        if(sign.equals("-")){
            //要操作的金额
            String cash=money.substring(1,money.length());
            sum=Integer.parseInt(cash);
            balance=balance-sum;
        }else if(sign.equals("+")){
            //要操作的金额
            String cash=money.substring(1,money.length());
            sum=Integer.parseInt(cash);
            balance=balance+sum;
        }else{
            sum=Integer.parseInt(money);           //没有输入+或- 直接转换
            balance=balance+sum;
        }

//        DecimalFormat df = new DecimalFormat("#0.00");
//        BigDecimal bigDecimal = new BigDecimal(balance);
//        balance=Integer.parseInt(df.format(bigDecimal));

        UserInfo userInfo=new UserInfo();
        userInfo.setUserid(user_Id);
        userInfo.setBalance(balance);
        DealDetail dealDetail=new DealDetail();
        dealDetail.setUserId(user_Id);
        dealDetail.setFinanceType(detailTypeName);
        dealDetail.setFinanceFund(sum);
        dealDetail.setBalance(balance);
        dealDetail.setRemark(memo);
        dealDetail.setCreateTime(new Date());
        if (userInfoBiz.updateUserInfo(userInfo)){
            if (dealDetailBiz.addDealDetail(dealDetail)){
                return "success";
            }
        }
        return "false";
    }
}
