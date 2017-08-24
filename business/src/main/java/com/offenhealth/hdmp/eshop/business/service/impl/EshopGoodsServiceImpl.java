package com.offenhealth.hdmp.eshop.business.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.offenhealth.hdmp.eshop.business.base.BaseService;
import com.offenhealth.hdmp.eshop.business.base.IBaseDao;
import com.offenhealth.hdmp.eshop.business.service.EshopGoodsService;
import com.offenhealth.hdmp.eshop.business.dao.EshopGoodsMapper;
import com.offenhealth.hdmp.eshop.bean.entity.EshopGoods;
import java.util.List;



/**
 * 
 *
 * @author hhy
 * @date 2017-08-24 13:44:59
 */
@Service("eshopGoodsService")
@Transactional
public class EshopGoodsServiceImpl extends BaseService<EshopGoods,String> implements EshopGoodsService  {

	@Autowired
	private EshopGoodsMapper eshopGoodsMapper;


    @Override
    protected IBaseDao <EshopGoods> getBaseDao() {
        return eshopGoodsMapper;
    }

    /**
     * 分页
     * @param pageNum   页码
     * @param pageSize  页数
     * @param search  搜索内容
     * @return PageInfo 分页信息
     */
    @Override
    public PageInfo<EshopGoods> pageList(int pageNum, int pageSize, String search) {
        PageHelper.startPage(pageNum, pageSize);
        List<EshopGoods> list = eshopGoodsMapper.pageList(search);
        PageInfo <EshopGoods> pageInfo = new PageInfo <>(list);
        return pageInfo;
    }

    /**
     * 批量删除
     * @param ids   id数组
     */
    @Override
    public void deleteBatch(String [] ids){
        eshopGoodsMapper.deleteBatch(ids);
    }
}
