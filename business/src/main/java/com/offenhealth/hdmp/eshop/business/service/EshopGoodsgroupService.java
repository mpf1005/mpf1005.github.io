package com.offenhealth.hdmp.eshop.business.service;

import  com.offenhealth.hdmp.eshop.bean.entity.EshopGoodsgroup;
import  com.offenhealth.hdmp.eshop.business.base.IBaseService;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @author hhy
 * @date 2017-08-21 15:36:32
 */
public interface EshopGoodsgroupService  extends IBaseService<EshopGoodsgroup, String> {


    /**
     * 分页
     * @param pageNum   页码
     * @param pageSize  页数
     * @param search  搜索内容
     * @return PageInfo 分页信息
     */
    public PageInfo<EshopGoodsgroup> pageList(int pageNum, int pageSize, String search) ;

    /**
     * 批量删除
     * @param ids   id数组
     */
    public void deleteBatch(String[] ids);


}
