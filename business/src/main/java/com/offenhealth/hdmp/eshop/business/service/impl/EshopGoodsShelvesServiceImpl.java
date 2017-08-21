package com.offenhealth.hdmp.eshop.business.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.offenhealth.hdmp.eshop.business.base.BaseService;
import com.offenhealth.hdmp.eshop.business.base.IBaseDao;
import com.offenhealth.hdmp.eshop.business.service.EshopGoodsShelvesService;
import com.offenhealth.hdmp.eshop.business.dao.EshopGoodsShelvesMapper;
import com.offenhealth.hdmp.eshop.bean.entity.EshopGoodsShelves;
import java.util.List;



/**
 * 
 *
 * @author hhy
 * @date 2017-08-21 15:36:33
 */
@Service("eshopGoodsShelvesService")
@Transactional
public class EshopGoodsShelvesServiceImpl extends BaseService<EshopGoodsShelves,String> implements EshopGoodsShelvesService  {

	@Autowired
	private EshopGoodsShelvesMapper eshopGoodsShelvesMapper;


    @Override
    protected IBaseDao <EshopGoodsShelves> getBaseDao() {
        return eshopGoodsShelvesMapper;
    }

    /**
     * 分页
     * @param pageNum   页码
     * @param pageSize  页数
     * @param search  搜索内容
     * @return PageInfo 分页信息
     */
    @Override
    public PageInfo<EshopGoodsShelves> pageList(int pageNum, int pageSize, String search) {
        PageHelper.startPage(pageNum, pageSize);
        List<EshopGoodsShelves> list = eshopGoodsShelvesMapper.pageList(search);
        PageInfo <EshopGoodsShelves> pageInfo = new PageInfo <>(list);
        return pageInfo;
    }

    /**
     * 批量删除
     * @param ids   id数组
     */
    @Override
    public void deleteBatch(String [] ids){
        eshopGoodsShelvesMapper.deleteBatch(ids);
    }
}
