package com.offenhealth.hdmp.eshop.business.service;

import com.github.pagehelper.PageInfo;
import com.offenhealth.hdmp.eshop.bean.entity.EshopProgroup;
import com.offenhealth.hdmp.eshop.bean.vo.EshopProgroupVO;
import com.offenhealth.hdmp.eshop.business.base.IBaseService;

/**
 * 
 * @author hhy
 * @date 2017-08-18 16:57:44
 */
public interface EshopProgroupService  extends IBaseService<EshopProgroup, String> {


    /**
     * 分页
     * @param pageNum   页码
     * @param pageSize  页数
     * @param search  搜索内容
     * @return PageInfo 分页信息
     */
    public PageInfo<EshopProgroupVO> pageList(int pageNum, int pageSize, String search) ;

    /**
     * 读取特定项目分组
     * @param String id
     */
    public EshopProgroupVO selectGroupByPrimaryKey(String id);

    /**
     * 新建项目分组
     * @param EshopProgroup eshopProgroup
     */
    public int insert(EshopProgroup eshopProgroup);

    /**
     * 编辑项目分组
     * @param EshopProgroup eshopProgroup
     */
    public int updateByPrimaryKey(EshopProgroup eshopProgroup);

    /**
     * 批量删除
     * @param ids   id数组
     */
    public void deleteBatch(String[] ids);


}
