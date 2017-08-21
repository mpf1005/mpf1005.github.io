package com.offenhealth.hdmp.eshop.business.dao;

import com.offenhealth.hdmp.eshop.bean.entity.EshopProgroup;
import com.offenhealth.hdmp.eshop.bean.vo.EshopProgroupVO;
import com.offenhealth.hdmp.eshop.business.base.IBaseDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 
 * 
 * @author hhy
 * @date 2017-08-18 16:57:44
 */
public interface EshopProgroupMapper extends IBaseDao<EshopProgroup> {
    //读取项目分组的列表(含分页，模糊查询)
    List<EshopProgroupVO> pageList(@Param("search") String search);

    //读取项目分组项目的数量
    int getEshopProjects(@Param("id") String id);

    void deleteBatch(@Param("ids") String [] ids);

}
