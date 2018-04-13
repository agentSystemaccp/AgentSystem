package com.accp.biz.impl;

import com.accp.biz.MenuBiz;
import com.accp.dao.MenuDao;
import com.accp.entity.Menu;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
@Service("menuBiz")
public class MenuBizImpl implements MenuBiz {
    @Resource(name="menuDao")
    private MenuDao menuDao;




    public List<com.accp.entity.Resource> findResourceList(Menu menu) {
        return menuDao.findResourceList(menu);
    }
}
