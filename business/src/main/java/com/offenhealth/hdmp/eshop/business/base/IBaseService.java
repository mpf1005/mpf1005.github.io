package com.offenhealth.hdmp.eshop.business.base;

import java.util.List;

/**
 * 通用接口
 * Created by earl on 2017/4/12.
 */
public interface IBaseService<T,PK> {


    int deleteByPrimaryKey(PK id);

    int insert(T record);
    int insertSelective(T record);

    T selectByPrimaryKey(PK id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

    List<T> select(T record);

    String getMaxSequenceNum();

}
