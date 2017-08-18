package com.offenhealth.hdmp.eshop.business.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.offenhealth.hdmp.eshop.business.base.BaseService;
import com.offenhealth.hdmp.eshop.business.base.IBaseDao;
import com.offenhealth.hdmp.eshop.business.service.EshopCongroupService;
import com.offenhealth.hdmp.eshop.business.dao.EshopCongroupMapper;
import com.offenhealth.hdmp.eshop.bean.entity.EshopCongroup;
import java.util.List;



/**
 * 
 *
 * @author hhy
 * @date 2017-08-18 16:57:44
 */
@Service("eshopCongroupService")
@Transactional
public class EshopCongroupServiceImpl extends BaseService<EshopCongroup,String> implements EshopCongroupService  {

	@Autowired
	private EshopCongroupMapper eshopCongroupMapper;


    @Override
    protected IBaseDao <EshopCongroup> getBaseDao() {
        return eshopCongroupMapper;
    }

    /**
     * 分页
     * @param pageNum   页码
     * @param pageSize  页数
     * @param search  搜索内容
     * @return PageInfo 分页信息
     */
    @Override
    public PageInfo<EshopCongroup> pageList(int pageNum, int pageSize, String search) {
        PageHelper.startPage(pageNum, pageSize);
        List<EshopCongroup> list = eshopCongroupMapper.pageList(search);
        PageInfo <EshopCongroup> pageInfo = new PageInfo <>(list);
        return pageInfo;
    }

    /**
     * 批量删除
     * @param ids   id数组
     */
    @Override
    public void deleteBatch(String [] ids){
        eshopCongroupMapper.deleteBatch(ids);
    }
}
