package com.offenhealth.hdmp.eshop.business.service.impl;


import com.offenhealth.hdmp.eshop.bean.entity.EshopConPro;
import com.offenhealth.hdmp.eshop.business.dao.EshopConProMapper;
import com.offenhealth.hdmp.eshop.common.constants.ResultCode;
import com.offenhealth.hdmp.eshop.common.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.offenhealth.hdmp.eshop.business.base.BaseService;
import com.offenhealth.hdmp.eshop.business.base.IBaseDao;
import com.offenhealth.hdmp.eshop.business.service.EshopConsumableService;
import com.offenhealth.hdmp.eshop.business.dao.EshopConsumableMapper;
import com.offenhealth.hdmp.eshop.bean.entity.EshopConsumable;
import java.util.List;



/**
 * 
 *
 * @author hhy
 * @date 2017-08-18 16:57:44
 */
@Service("eshopConsumableService")
@Transactional
public class EshopConsumableServiceImpl extends BaseService<EshopConsumable,String> implements EshopConsumableService  {

	@Autowired
	private EshopConsumableMapper eshopConsumableMapper;
    @Autowired
    private EshopConProMapper eshopConProMapper;

    @Override
    protected IBaseDao <EshopConsumable> getBaseDao() {
        return eshopConsumableMapper;
    }

    /**
     * 分页
     * @param pageNum   页码
     * @param pageSize  页数
     * @param search  搜索内容
     * @return PageInfo 分页信息
     */
    @Override
    public PageInfo<EshopConsumable> pageList(int pageNum, int pageSize, String search) {
        PageHelper.startPage(pageNum, pageSize);
        List<EshopConsumable> list = eshopConsumableMapper.pageList(search);
        PageInfo <EshopConsumable> pageInfo = new PageInfo <>(list);
        return pageInfo;
    }

    /**
     * 批量删除
     * @param ids   id数组
     */
    @Override
    public void deleteBatch(String [] ids){
        eshopConsumableMapper.deleteBatch(ids);
    }

    @Override
    public void deleteConsumable(String id) {
        //先查询有没有这个耗材
        EshopConsumable consumable = eshopConsumableMapper.selectByPrimaryKey(id);
        if (consumable==null){
            throw  new ServiceException(ResultCode.NO_CONSUNABLE_BY_ID.getCode(),ResultCode.NO_CONSUNABLE_BY_ID.getMsg());
        }
        EshopConPro eshopConPro =new EshopConPro();
        eshopConPro.setConsumableId(id);
        //查询这个耗材有没有跟项目关联
        List<EshopConPro> selectList = eshopConProMapper.select(eshopConPro);
        if (selectList.size()>0){
            throw  new ServiceException(ResultCode.CANT_DELECT_CONSUNABLE.getCode(),ResultCode.CANT_DELECT_CONSUNABLE.getMsg());
        }
        eshopConsumableMapper.delete(consumable);
    }
}
