package com.offenhealth.hdmp.eshop.business.dao;

import java.util.List;
import com.offenhealth.hdmp.eshop.business.base.IBaseDao;
import com.offenhealth.hdmp.eshop.bean.entity.EshopGoodsShelves;
import org.apache.ibatis.annotations.Param;


/**
 * 
 * 
 * @author hhy
 * @date 2017-08-21 15:36:33
 */
public interface EshopGoodsShelvesMapper extends IBaseDao<EshopGoodsShelves> {

    List<EshopGoodsShelves> pageList(@Param("search") String search);

    void deleteBatch(@Param("ids") String[] ids);

}
