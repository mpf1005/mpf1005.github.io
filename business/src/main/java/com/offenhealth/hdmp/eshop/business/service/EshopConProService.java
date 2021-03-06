package com.offenhealth.hdmp.eshop.business.service;

import  com.offenhealth.hdmp.eshop.bean.entity.EshopConPro;
import  com.offenhealth.hdmp.eshop.business.base.IBaseService;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @author hhy
 * @date 2017-08-22 13:46:21
 */
public interface EshopConProService  extends IBaseService<EshopConPro, String> {


    /**
     * 分页
     * @param pageNum   页码
     * @param pageSize  页数
     * @param search  搜索内容
     * @return PageInfo 分页信息
     */
    public PageInfo<EshopConPro> pageList(int pageNum, int pageSize, String search) ;

    /**
     * 批量删除
     * @param ids   id数组
     */
    public void deleteBatch(String[] ids);


}
