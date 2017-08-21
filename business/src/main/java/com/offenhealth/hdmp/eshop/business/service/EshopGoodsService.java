package com.offenhealth.hdmp.eshop.business.service;

import  com.offenhealth.hdmp.eshop.bean.entity.EshopGoods;
import  com.offenhealth.hdmp.eshop.business.base.IBaseService;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 
 * @author hhy
 * @date 2017-08-21 15:36:33
 */
public interface EshopGoodsService  extends IBaseService<EshopGoods, String> {

    /*
    *@Author:johnson
    *@Description:商品添加（实物）
    *@Date:16:03 2017/8/21
    */
    public int AddGoods(EshopGoods eshopGoods);

   /*
   *@Author:johnson
   *@Description:商品删除
   *@Date:16:22 2017/8/21
   */
    public int deleteByGoodsId(String id);

    /*
    *@Author:johnson
    *@Description:商品更改
    *@Date:16:30 2017/8/21
    */
    public int updateGoods(EshopGoods eshopGoods);

    /**
     * 分页
     * @param pageNum   页码
     * @param pageSize  页数
     * @param search  搜索内容
     * @return PageInfo 分页信息
     */
    public PageInfo<EshopGoods> pageList(int pageNum, int pageSize, String search) ;

    /**
     * 批量删除
     * @param ids   id数组
     */
    public void deleteBatch(String[] ids);


}
