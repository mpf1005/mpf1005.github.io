package com.offenhealth.hdmp.eshop.business.service;

import  com.offenhealth.hdmp.eshop.bean.entity.EshopCongroup;
import com.offenhealth.hdmp.eshop.bean.vo.EshopCongroupVO;
import  com.offenhealth.hdmp.eshop.business.base.IBaseService;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @author hhy
 * @date 2017-08-18 16:57:44
 */
public interface EshopCongroupService  extends IBaseService<EshopCongroup, String> {


    /**
     * 分页
     * @param pageNum   页码
     * @param pageSize  页数
     * @param search  搜索内容
     * @return PageInfo 分页信息
     */
    public PageInfo<EshopCongroup> pageList(int pageNum, int pageSize, String search) ;

    /**
     * 批量删除
     * @param ids   id数组
     */
    public void deleteBatch(String[] ids);


    public int insert (EshopCongroup eshopCongroup);

    public EshopCongroupVO selectByPrimaryKey(String id);

    public  int  updateByPrimaryKey(EshopCongroup vo);
}
