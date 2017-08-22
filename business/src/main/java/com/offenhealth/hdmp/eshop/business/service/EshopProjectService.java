package com.offenhealth.hdmp.eshop.business.service;

import com.github.pagehelper.PageInfo;
import com.offenhealth.hdmp.eshop.bean.entity.EshopProject;
import com.offenhealth.hdmp.eshop.bean.vo.EshopProjectVO;
import com.offenhealth.hdmp.eshop.business.base.IBaseService;

/**
 * 
 * @author hhy
 * @date 2017-08-18 16:57:44
 */
public interface EshopProjectService  extends IBaseService<EshopProject, String> {


    /**
     * 分页
     * @param pageNum   页码
     * @param pageSize  页数
     * @param search  搜索内容
     * @return PageInfo 分页信息
     */
    public PageInfo<EshopProject> pageList(int pageNum, int pageSize, String search) ;

    /**
     * 新建项目
     * EshopProjectVO eshopProjectVO
     */
    public int insert(EshopProjectVO eshopProjectVO);

    /**
     * 批量删除
     * @param ids   id数组
     */
    public void deleteBatch(String[] ids);


}
