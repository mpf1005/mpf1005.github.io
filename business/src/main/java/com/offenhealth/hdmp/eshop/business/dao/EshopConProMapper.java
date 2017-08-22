package com.offenhealth.hdmp.eshop.business.dao;

import java.util.List;
import com.offenhealth.hdmp.eshop.business.base.IBaseDao;
import com.offenhealth.hdmp.eshop.bean.entity.EshopConPro;
import org.apache.ibatis.annotations.Param;


/**
 * 
 * 
 * @author hhy
 * @date 2017-08-22 13:46:21
 */
public interface EshopConProMapper extends IBaseDao<EshopConPro> {

    List<EshopConPro> pageList(@Param("search") String search);

    void deleteBatch(@Param("ids") String[] ids);

}
