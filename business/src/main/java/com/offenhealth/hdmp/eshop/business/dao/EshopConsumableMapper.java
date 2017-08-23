package com.offenhealth.hdmp.eshop.business.dao;

import java.util.List;

import com.offenhealth.hdmp.eshop.bean.vo.EshopConsumableVO;
import com.offenhealth.hdmp.eshop.business.base.IBaseDao;
import com.offenhealth.hdmp.eshop.bean.entity.EshopConsumable;
import org.apache.ibatis.annotations.Param;


/**
 * 
 * 
 * @author hhy
 * @date 2017-08-18 16:57:44
 */
public interface EshopConsumableMapper extends IBaseDao<EshopConsumable> {

    List<EshopConsumableVO> pageList(@Param("search") String search);

    void deleteBatch(@Param("ids") String [] ids);

    EshopConsumableVO queryConsumablesInfo(@Param("id") String id);//查询特定耗材
    /**
     * 获取耗材总数
     * @return
     */
    public int countConsumableNum();
}
