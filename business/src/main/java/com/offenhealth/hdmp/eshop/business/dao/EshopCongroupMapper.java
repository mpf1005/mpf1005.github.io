package com.offenhealth.hdmp.eshop.business.dao;

import com.offenhealth.hdmp.eshop.bean.entity.EshopCongroup;
import com.offenhealth.hdmp.eshop.business.base.IBaseDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 
 * 
 * @author hhy
 * @date 2017-08-18 16:57:44
 */
public interface EshopCongroupMapper extends IBaseDao<EshopCongroup> {

    List<EshopCongroup> pageList(@Param("search") String search);

    void deleteBatch(@Param("ids") String [] ids);

}
