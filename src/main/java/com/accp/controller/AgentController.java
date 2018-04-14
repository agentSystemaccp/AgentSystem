package com.accp.controller;

import com.accp.biz.CustomerBiz;
import com.accp.biz.KeywordBiz;
import com.accp.biz.TypeBiz;
import com.accp.entity.Customer;
import com.accp.entity.Keyword;
import com.accp.entity.UserInfo;
import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 代理商控制器
 */
@Controller
@RequestMapping(value="/agent")
public class AgentController {

    @Resource
    private CustomerBiz customerBiz;
    @Resource
    private TypeBiz typeBiz;
    @Resource
    private KeywordBiz keywordBiz;



//    -------------------------------关键词申请------------------------------
    /**
     * 点击搜索框显示当前登录用户的所有客户
     * @return
     */
    @RequestMapping("/searchcustomer")
    @ResponseBody
    public Object searchcustom(String companyName,HttpSession session){
        int uid = ((UserInfo)session.getAttribute("userLogin")).getUserid();
        Customer customer = new Customer();
        customer.setUserId(uid);
        customer.setCompanyStatus(1);
        customer.setCompanyName(companyName);
        List<Customer> customerList = customerBiz.queryCustomBySearch(customer);
        return JSONArray.toJSONString(customerList);
    }


    /**
     * 加载服务类别
     * @return
     */
    @RequestMapping("/loadServiceType")
    @ResponseBody
    public Object loadServiceType(){
        return JSONArray.toJSONString(typeBiz.queryTypeByParentId(3));
    }

    /**
     * 关键词动态验证
     * @return
     */
    @RequestMapping("/valikey")
    @ResponseBody
    public Object valikey(String keyword){
        Keyword keyWord = new Keyword();
        keyWord.setKeyword(keyword);
        if(keywordBiz.queryByKeyWord(keyWord)==null){
            return "success";
        }
        return "fail";
    }


    /**
     * 动态计算价格
     * @return
     */
    @RequestMapping("/calculate")
    @ResponseBody
    public Object calculate(String servicetype,String serviceyear){
        int total = 0;
        if(servicetype.equals("20")){      //一年26000
            total= serviceyear.equals("买二赠一") ? 2*26000 :Integer.parseInt(serviceyear)*26000;
        }else if(servicetype.equals("21")){    //一年18000
            total= serviceyear.equals("买二赠一") ? 2*18000 :Integer.parseInt(serviceyear)*18000;
        }else {
            return "exception";
        }
        return JSONArray.toJSONString(total);
    }

    /**
     * 余额验证
     * @return
     */
    @RequestMapping("/valiBalance")
    @ResponseBody
    public Object valiBalance(String balance,HttpSession session){
        return ((UserInfo)session.getAttribute("userLogin")).getBalance()<Integer.parseInt(balance) ? "nomoney":"sucess";
    }


    /**
     * 关键词提交申请
     * @return
     */

    @RequestMapping("/submitkeyword")
    @ResponseBody
    public Object submitKeyword(String price,String keyword,String customerId,String servicetype ,String serviceyear,HttpSession session){
        UserInfo userInfo = ((UserInfo)session.getAttribute("userLogin"));
        Keyword keyWord = new Keyword();
        keyWord.setUserId(userInfo.getUserid());
        keyWord.setKeyword(keyword);
        keyWord.setCustomerId(Integer.parseInt(customerId));
        keyWord.setCreateTime(new Date());
        keyWord.setKeywordStatus(1);
        keyWord.setTypeId(Integer.parseInt(servicetype));
        keyWord.setTerm(serviceyear.equals("买二赠一") ? 2:Integer.parseInt(serviceyear));
        if(keywordBiz.addKeyWord(keyWord,userInfo,Integer.parseInt(price))>0){
            return "success";
        }
        return "failed";
    }


    /**
     * 空跳至关键词页面
     * @return
     */
    @RequestMapping("/toKeyWord")
    public String toKeyWord(){
        return "keyword";
    }
}
