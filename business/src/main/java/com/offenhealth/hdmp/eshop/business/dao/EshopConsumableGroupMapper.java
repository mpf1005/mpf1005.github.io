package com.offenhealth.hdmp.eshop.business.dao;

import java.util.List;
import com.offenhealth.hdmp.eshop.business.base.IBaseDao;
import com.offenhealth.hdmp.eshop.bean.entity.EshopConsumableGroup;
import org.apache.ibatis.annotations.Param;


/**
 * 
 * 
 * @author hhy
 * @date 2017-08-18 16:57:44
 */
public interface EshopConsumableGroupMapper extends IBaseDao<EshopConsumableGroup> {

    List<EshopConsumableGroup> pageList(@Param("search") String search);

    void deleteBatch(@Param("ids") String [] ids);

}
