package com.offenhealth.hdmp.eshop.business.service.impl;

import com.offenhealth.hdmp.eshop.bean.entity.EshopProgroup;
import com.offenhealth.hdmp.eshop.bean.vo.EshopProgroupVO;
import com.offenhealth.hdmp.eshop.bean.vo.EshopProgroupCountVO;
import com.offenhealth.hdmp.eshop.business.base.BaseService;
import com.offenhealth.hdmp.eshop.business.base.IBaseDao;
import com.offenhealth.hdmp.eshop.business.dao.EshopProgroupMapper;
import com.offenhealth.hdmp.eshop.business.service.EshopProgroupService;
import com.offenhealth.hdmp.eshop.common.constants.ResultCode;
import com.offenhealth.hdmp.eshop.common.exception.ServiceException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 
 *
 * @author hhy
 * @date 2017-08-18 16:57:44
 */
@Service("eshopProgroupService")
@Transactional
public class EshopProgroupServiceImpl extends BaseService<EshopProgroup,String> implements EshopProgroupService  {
    /*
     *注入eshopProgroupService接口
     */
	@Autowired
	private EshopProgroupMapper eshopProgroupMapper;


    @Override
    protected IBaseDao <EshopProgroup> getBaseDao() {
        return eshopProgroupMapper;
    }

    /**
     * 分页
     * @param pageNum   页码
     * @param pageSize  页数
     * @param search  搜索内容
     * @return PageInfo 分页信息
     */
    public EshopProgroupCountVO pageList(int pageNum, int pageSize, String search) {
        EshopProgroupCountVO eshopProjectVO = new EshopProgroupCountVO();
        int getcount = eshopProgroupMapper.getcount();
        List<EshopProgroupVO> list = eshopProgroupMapper.pageList(search);
        for(EshopProgroupVO eshopProgroup:list){
            //读取项目分组项目的数量
            int count=eshopProgroupMapper.getEshopProjects(eshopProgroup.getId());
            eshopProgroup.setProjectNumber(count);
        }
        eshopProjectVO.setCount(getcount);
        eshopProjectVO.setEshopProgroupVOS(list);
        return eshopProjectVO;
    }
    /**
     * 读取特定项目分组
     * @param String id
     */
    @Override
    public EshopProgroupVO selectGroupByPrimaryKey(String id) {
        //读取特定项目分组
        EshopProgroup eshopProgroup = eshopProgroupMapper.selectByPrimaryKey(id);
        if(eshopProgroup==null){
            throw new ServiceException(ResultCode.NO_GROUP_BY_ID.getCode(),ResultCode.NO_GROUP_BY_ID.getMsg());
        }
        EshopProgroupVO eshopProgroupVO = new EshopProgroupVO();
        //读取项目分组项目的数量
        int count=eshopProgroupMapper.getEshopProjects(eshopProgroup.getId());
        //将eshopProgroup获取的数据拷贝给eshopProgroupVO
        BeanUtils.copyProperties(eshopProgroup,eshopProgroupVO);
        eshopProgroupVO.setProjectNumber(count);
        return eshopProgroupVO;
    }

    /**
     * 新建项目分组
     * @param EshopProgroup eshopProgroup
     */
    @Override
    public int insert(EshopProgroup eshopProgroup){
        if(eshopProgroup.getName()==null){
            throw new ServiceException(ResultCode.NAME_CANNOT_BE_EMPTY.getCode(),ResultCode.NAME_CANNOT_BE_EMPTY.getMsg());
        }
        eshopProgroup.setCode("1");
        eshopProgroup.setStatus("1");
        eshopProgroup.setCreateUser("aa");
        eshopProgroup.setCreateTime(new Date());
        eshopProgroup.setLastMUser("bb");
        eshopProgroup.setLastMTime(new Date());
        return eshopProgroupMapper.insert(eshopProgroup);
    }

    /**
     * 新建项目分组
     * @param EshopProgroup eshopProgroup
     */
    @Override
    public int updateByPrimaryKey(EshopProgroup eshopProgroup){
        if(eshopProgroup.getName()==null){
            throw new ServiceException(ResultCode.NAME_CANNOT_BE_EMPTY.getCode(),ResultCode.NAME_CANNOT_BE_EMPTY.getMsg());
        }
        eshopProgroup.setCode("1");
        eshopProgroup.setStatus("1");
        eshopProgroup.setCreateUser("aa");
        eshopProgroup.setCreateTime(new Date());
        eshopProgroup.setLastMUser("bb");
        eshopProgroup.setLastMTime(new Date());
        return eshopProgroupMapper.updateByPrimaryKey(eshopProgroup);
    }

    /**
     * 删除项目的分组
     * @param ids  id
     */
    @Override
    public int deleteByPrimaryKey(String id)
    {
        return eshopProgroupMapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除
     * @param ids   id数组
     */
    @Override
    public void deleteBatch(String [] ids){
        eshopProgroupMapper.deleteBatch(ids);
    }
}
