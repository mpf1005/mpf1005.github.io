package com.offenhealth.hdmp.eshop.business.dao;

import java.util.List;
import com.offenhealth.hdmp.eshop.business.base.IBaseDao;
import com.offenhealth.hdmp.eshop.bean.entity.EshopService;
import org.apache.ibatis.annotations.Param;


/**
 * 
 * 
 * @author hhy
 * @date 2017-08-24 13:44:59
 */
public interface EshopServiceMapper extends IBaseDao<EshopService> {

    List<EshopService> pageList(@Param("search") String search);

    void deleteBatch(@Param("ids") String[] ids);

}
