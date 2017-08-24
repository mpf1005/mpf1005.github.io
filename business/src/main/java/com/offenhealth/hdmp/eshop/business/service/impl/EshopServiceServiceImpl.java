package com.offenhealth.hdmp.eshop.business.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.offenhealth.hdmp.eshop.business.base.BaseService;
import com.offenhealth.hdmp.eshop.business.base.IBaseDao;
import com.offenhealth.hdmp.eshop.business.service.EshopServiceService;
import com.offenhealth.hdmp.eshop.business.dao.EshopServiceMapper;
import com.offenhealth.hdmp.eshop.bean.entity.EshopService;
import java.util.List;



/**
 * 
 *
 * @author hhy
 * @date 2017-08-24 13:44:59
 */
@Service("eshopServiceService")
@Transactional
public class EshopServiceServiceImpl extends BaseService<EshopService,String> implements EshopServiceService  {

	@Autowired
	private EshopServiceMapper eshopServiceMapper;


    @Override
    protected IBaseDao <EshopService> getBaseDao() {
        return eshopServiceMapper;
    }

    /**
     * 分页
     * @param pageNum   页码
     * @param pageSize  页数
     * @param search  搜索内容
     * @return PageInfo 分页信息
     */
    @Override
    public PageInfo<EshopService> pageList(int pageNum, int pageSize, String search) {
        PageHelper.startPage(pageNum, pageSize);
        List<EshopService> list = eshopServiceMapper.pageList(search);
        PageInfo <EshopService> pageInfo = new PageInfo <>(list);
        return pageInfo;
    }

    /**
     * 批量删除
     * @param ids   id数组
     */
    @Override
    public void deleteBatch(String [] ids){
        eshopServiceMapper.deleteBatch(ids);
    }
}
