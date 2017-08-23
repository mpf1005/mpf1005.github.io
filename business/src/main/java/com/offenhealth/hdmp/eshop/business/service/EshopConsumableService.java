package com.offenhealth.hdmp.eshop.business.service;

import  com.offenhealth.hdmp.eshop.bean.entity.EshopConsumable;
import com.offenhealth.hdmp.eshop.bean.vo.EshopConsumableVO;
import  com.offenhealth.hdmp.eshop.business.base.IBaseService;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @author hhy
 * @date 2017-08-18 16:57:44
 */
public interface EshopConsumableService  extends IBaseService<EshopConsumable, String> {


    /*
    *@Author:johnson
    *@Description:新增耗材
    *@Date:18:56 2017/8/21
    */
    int insertConsumable(EshopConsumableVO eshopConsumableVO);


    /*
    *@Author:johnson
    *@Description:查找特定耗材
    *@Date:13:53 2017/8/22
    */
    public EshopConsumableVO queryConsumablesInfo(String id);

    /**
     * 分页
     * @param pageNum   页码
     * @param pageSize  页数
     * @param search  搜索内容
     * @return PageInfo 分页信息
     */
    public PageInfo<EshopConsumableVO> pageList(int pageNum, int pageSize, String search) ;

    /**
     * 批量删除
     * @param ids   id数组
     */
    public void deleteBatch(String[] ids);

    void deleteConsumable(String id);
}
