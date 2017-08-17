package com.offenhealth.hdmp.eshop.business.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 通用DAO接口
 * Created by earl on 2017/4/12.
 */
public interface IBaseDao<T> extends Mapper<T>, MySqlMapper<T> {

}
