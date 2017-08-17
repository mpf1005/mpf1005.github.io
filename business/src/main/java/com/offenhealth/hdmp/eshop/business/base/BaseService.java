package com.offenhealth.hdmp.eshop.business.base;

import java.util.List;

/**
 * 超类Service
 * Created by earl on 2017/4/12.
 */
public abstract class BaseService<T, PK> implements IBaseService<T, PK> {

    /**
     * 用子类返回的dao操作，具有通用性和支持事务
     */
    protected abstract IBaseDao<T> getBaseDao();

    @Override
    public String getMaxSequenceNum() {
        return null;
    }

    /**
     *  删除记录
     * @param id 主键
     */
    public int deleteByPrimaryKey(PK id) {
        return getBaseDao().deleteByPrimaryKey(id);
    }
    /**
     *  插入记录
     * @param record 实体
     */
    public int insert(T record) {
        int total = getBaseDao().insert(record);
        return total;
    }
    /**
     *  精确插入记录
     */
    public int insertSelective(T record) {

        return getBaseDao().insertSelective(record);
    }
    /**
     *  查询一条记录
     * @param id 主键
     */
    public T selectByPrimaryKey(PK id) {
        return getBaseDao().selectByPrimaryKey(id);
    }

    /**
     *
     * @param record
     * @return
     */
    public int updateByPrimaryKeySelective(T record) {
        return getBaseDao().updateByPrimaryKeySelective(record);
    }
    /**
     * 更新记录
     * @param record 实体
     */
    public int updateByPrimaryKey(T record) {
        return getBaseDao().updateByPrimaryKey(record);
    }

    /**
     *  根据属性条件进行查询
     * @param record 实体
     * @return List<T>
     */
    public List<T> select(T record) {
        return getBaseDao().select(record);
    }

}
