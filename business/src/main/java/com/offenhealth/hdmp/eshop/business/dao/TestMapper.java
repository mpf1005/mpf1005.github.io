package com.offenhealth.hdmp.eshop.business.dao;

import java.util.List;
import com.offenhealth.hdmp.eshop.business.base.IBaseDao;
import com.offenhealth.hdmp.eshop.bean.entity.Test;
import org.apache.ibatis.annotations.Param;


/**
 * 
 * 
 * @author hhy
 * @date 2017-08-17 15:35:21
 */
public interface TestMapper extends IBaseDao<Test> {

    List<Test> pageList(@Param("search") String search);

    void deleteBatch(@Param("ids") String[] ids);

}
