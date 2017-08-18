package com.offenhealth.hdmp.eshop.business.dao;

import java.util.List;
import com.offenhealth.hdmp.eshop.business.base.IBaseDao;
import com.offenhealth.hdmp.eshop.bean.entity.EshopReceipt;
import org.apache.ibatis.annotations.Param;


/**
 * 
 * 
 * @author hhy
 * @date 2017-08-18 16:57:44
 */
public interface EshopReceiptMapper extends IBaseDao<EshopReceipt> {

    List<EshopReceipt> pageList(@Param("search") String search);

    void deleteBatch(@Param("ids") String [] ids);

}
