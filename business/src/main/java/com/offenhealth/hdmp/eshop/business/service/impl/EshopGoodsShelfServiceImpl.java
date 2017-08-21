package com.offenhealth.hdmp.eshop.business.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.offenhealth.hdmp.eshop.business.base.BaseService;
import com.offenhealth.hdmp.eshop.business.base.IBaseDao;
import com.offenhealth.hdmp.eshop.business.service.EshopGoodsShelfService;
import com.offenhealth.hdmp.eshop.business.dao.EshopGoodsShelfMapper;
import com.offenhealth.hdmp.eshop.bean.entity.EshopGoodsShelf;
import java.util.List;



/**
 * 
 *
 * @author hhy
 * @date 2017-08-21 15:36:33
 */
@Service("eshopGoodsShelfService")
@Transactional
public class EshopGoodsShelfServiceImpl extends BaseService<EshopGoodsShelf,String> implements EshopGoodsShelfService  {

	@Autowired
	private EshopGoodsShelfMapper eshopGoodsShelfMapper;


    @Override
    protected IBaseDao <EshopGoodsShelf> getBaseDao() {
        return eshopGoodsShelfMapper;
    }

    /**
     * 分页
     * @param pageNum   页码
     * @param pageSize  页数
     * @param search  搜索内容
     * @return PageInfo 分页信息
     */
    @Override
    public PageInfo<EshopGoodsShelf> pageList(int pageNum, int pageSize, String search) {
        PageHelper.startPage(pageNum, pageSize);
        List<EshopGoodsShelf> list = eshopGoodsShelfMapper.pageList(search);
        PageInfo <EshopGoodsShelf> pageInfo = new PageInfo <>(list);
        return pageInfo;
    }

    /**
     * 批量删除
     * @param ids   id数组
     */
    @Override
    public void deleteBatch(String [] ids){
        eshopGoodsShelfMapper.deleteBatch(ids);
    }
}
