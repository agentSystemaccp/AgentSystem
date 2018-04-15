package com.accp.biz.impl;

import com.accp.biz.KeywordBiz;
import com.accp.dao.DealDetailDao;
import com.accp.dao.KeyWordDao;
import com.accp.dao.UserInfoDao;
import com.accp.entity.DealDetail;
import com.accp.entity.Keyword;
import com.accp.entity.UserInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class KeywordBizImpl implements KeywordBiz {

    @Resource
    private KeyWordDao keyWordDao;

    @Resource
    private DealDetailDao dealDetailDao;
    @Resource
    private UserInfoDao userInfoDao;

    /**
     * 添加关键词,冻结资金,添加明细
     * @param keyword
     * @return
     */
   public int addKeyWord(Keyword keyword, UserInfo userInfo,int price) {
       //冻结一年资金资金
       userInfo.setBalance(userInfo.getBalance()-(price/keyword.getTerm()));
       userInfoDao.updateUserInfo(userInfo);

       //添加明细
       DealDetail dealDetail = new DealDetail();
       dealDetail.setUserId(userInfo.getUserid());
       dealDetail.setBalance((float) userInfo.getBalance()-(price/keyword.getTerm()));
       dealDetail.setCreateTime(new Date());
       dealDetail.setFinanceFund(-price/keyword.getTerm());
       dealDetail.setFinanceType("预注册冻结资金");
       dealDetail.setRemark(userInfo.getUserName()+"对"+keyword.getKeyword()+"进行关键词申请预注册操作,冻结资金:"+price/keyword.getTerm());
       dealDetailDao.addDealDetail(dealDetail);


       return keyWordDao.addKeyWord(keyword);
   }


    /**
     * 动态验证关键词是否存在
     * @param keyword
     * @return
     */
    public Keyword queryByKeyWord(Keyword keyword) {
        return keyWordDao.queryByKeyWord(keyword);
    }
}
