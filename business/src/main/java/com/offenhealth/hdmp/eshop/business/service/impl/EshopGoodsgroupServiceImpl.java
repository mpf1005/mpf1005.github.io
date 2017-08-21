package com.offenhealth.hdmp.eshop.business.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.offenhealth.hdmp.eshop.business.base.BaseService;
import com.offenhealth.hdmp.eshop.business.base.IBaseDao;
import com.offenhealth.hdmp.eshop.business.service.EshopGoodsgroupService;
import com.offenhealth.hdmp.eshop.business.dao.EshopGoodsgroupMapper;
import com.offenhealth.hdmp.eshop.bean.entity.EshopGoodsgroup;
import java.util.List;



/**
 * 
 *
 * @author hhy
 * @date 2017-08-21 15:36:32
 */
@Service("eshopGoodsgroupService")
@Transactional
public class EshopGoodsgroupServiceImpl extends BaseService<EshopGoodsgroup,String> implements EshopGoodsgroupService  {

	@Autowired
	private EshopGoodsgroupMapper eshopGoodsgroupMapper;


    @Override
    protected IBaseDao <EshopGoodsgroup> getBaseDao() {
        return eshopGoodsgroupMapper;
    }

    /**
     * 分页
     * @param pageNum   页码
     * @param pageSize  页数
     * @param search  搜索内容
     * @return PageInfo 分页信息
     */
    @Override
    public PageInfo<EshopGoodsgroup> pageList(int pageNum, int pageSize, String search) {
        PageHelper.startPage(pageNum, pageSize);
        List<EshopGoodsgroup> list = eshopGoodsgroupMapper.pageList(search);
        PageInfo <EshopGoodsgroup> pageInfo = new PageInfo <>(list);
        return pageInfo;
    }

    /**
     * 批量删除
     * @param ids   id数组
     */
    @Override
    public void deleteBatch(String [] ids){
        eshopGoodsgroupMapper.deleteBatch(ids);
    }
}
