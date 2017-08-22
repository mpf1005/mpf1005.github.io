package com.offenhealth.hdmp.eshop.business.service.impl;


import com.offenhealth.hdmp.eshop.bean.vo.EshopCongroupCountVO;
import com.offenhealth.hdmp.eshop.bean.vo.EshopCongroupVO;
import com.offenhealth.hdmp.eshop.business.dao.EshopConsumableGroupMapper;
import com.offenhealth.hdmp.eshop.business.dao.EshopConsumableMapper;
import com.offenhealth.hdmp.eshop.common.constants.ResultCode;
import com.offenhealth.hdmp.eshop.common.exception.ServiceException;
import com.offenhealth.hdmp.eshop.common.util.BeanUtils;
import com.offenhealth.hdmp.eshop.common.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.offenhealth.hdmp.eshop.business.base.BaseService;
import com.offenhealth.hdmp.eshop.business.base.IBaseDao;
import com.offenhealth.hdmp.eshop.business.service.EshopCongroupService;
import com.offenhealth.hdmp.eshop.business.dao.EshopCongroupMapper;
import com.offenhealth.hdmp.eshop.bean.entity.EshopCongroup;

import java.util.Date;
import java.util.List;



/**
 * 
 *
 * @author hhy
 * @date 2017-08-18 16:57:44
 */
@Service("eshopCongroupService")
@Transactional
public class EshopCongroupServiceImpl extends BaseService<EshopCongroup,String> implements EshopCongroupService  {

	@Autowired
	private EshopCongroupMapper eshopCongroupMapper;
    @Autowired
    private EshopConsumableGroupMapper eshopConsumableGroupMapper;
    @Autowired
    private EshopConsumableMapper eshopConsumableMapper;
    @Override
    protected IBaseDao <EshopCongroup> getBaseDao() {
        return eshopCongroupMapper;
    }

    /**
     * 分页
     * @param pageNum   页码
     * @param pageSize  页数
     * @param search  搜索内容
     * @return PageInfo 分页信息
     */
    @Override
    public PageInfo<EshopCongroup> pageList(int pageNum, int pageSize, String search) {
        PageHelper.startPage(pageNum, pageSize);
        List<EshopCongroup> list = eshopCongroupMapper.pageList(search);
        PageInfo <EshopCongroup> pageInfo = new PageInfo <>(list);
        return pageInfo;
    }

    /**
     * 批量删除
     * @param ids   id数组
     */
    @Override
    public void deleteBatch(String [] ids){
        eshopCongroupMapper.deleteBatch(ids);
    }

    /**
     * 耗材分组保存
     * @param eshopCongroup
     * @return 耗材id
     */
    @Override
    public int insert(EshopCongroup eshopCongroup){
        if (eshopCongroup.getName()==null){
            throw  new ServiceException(ResultCode.NAME_CANNOT_BE_EMPTY.getCode(),ResultCode.NAME_CANNOT_BE_EMPTY.getMsg());
        }
        eshopCongroup.setCreateTime(new Date());
        eshopCongroup.setLastMTime(new Date());
        eshopCongroup.setCode("1");
        eshopCongroup.setCreateUser(UserUtil.getuser());
        eshopCongroup.setStatus("1");
        eshopCongroup.setLastMUser(UserUtil.getuser());
      return   eshopCongroupMapper.insert(eshopCongroup);

    }

    /**
     * 读取指定分组
     * @param id 主键
     * @return
     */
    @Override
    public EshopCongroupVO selectByPrimaryKey(String id){
        //获取到指定的分组
        EshopCongroup eshopCongroup = eshopCongroupMapper.selectByPrimaryKey(id);
        if (eshopCongroup==null){
            throw  new ServiceException( ResultCode.NO_GROUP_BY_ID.getCode(),ResultCode.NO_GROUP_BY_ID.getMsg());
        }
        EshopCongroupVO eshopCongroupVO = new EshopCongroupVO();
        BeanUtils.copyProperties(eshopCongroup,eshopCongroupVO);
        //得到指定分组下的耗材数量
        int conNum = eshopConsumableGroupMapper.getCountByGroupID(id);
        eshopCongroupVO.setConsumableNumber(conNum);
        return eshopCongroupVO;
    }

    /**
     * 更新耗材分组信息
     * @param eshopCongroup
     * @return
     */
    @Override
    public  int updateByPrimaryKey(EshopCongroup eshopCongroup){
        if (eshopCongroup.getName()==null){
            throw  new ServiceException(ResultCode.NAME_CANNOT_BE_EMPTY.getCode(),ResultCode.NAME_CANNOT_BE_EMPTY.getMsg());
        }
        eshopCongroup.setLastMTime(new Date());
        eshopCongroup.setLastMUser(UserUtil.getuser());
        return eshopCongroupMapper.updateByPrimaryKey(eshopCongroup);

    }

    /**
     * 删除指定分组
     * @param id 主键
     * @return
     */
    @Override
    public  int  deleteByPrimaryKey(String id){
        EshopCongroup eshopCongroup = eshopCongroupMapper.selectByPrimaryKey(id);
        if (eshopCongroup==null){
            throw  new ServiceException( ResultCode.NO_GROUP_BY_ID.getCode(),ResultCode.NO_GROUP_BY_ID.getMsg());
        }
        return eshopCongroupMapper.deleteByPrimaryKey(id);
    }

    @Override
    public EshopCongroupCountVO getlist() {
        EshopCongroupCountVO eshopCongroupCountVO = new EshopCongroupCountVO();
        //获取耗材所有分组
        List<EshopCongroupVO> eshopCongroups = eshopCongroupMapper.getList();
        //获取耗材总数
        int countConsumableNun = eshopConsumableMapper.countConsumableNum();
        //循环遍历将每一个分组的耗材数量set进去
        for (EshopCongroupVO eshopCongroupVO: eshopCongroups) {
            int countByGroupID = eshopConsumableGroupMapper.getCountByGroupID(eshopCongroupVO.getId());
            eshopCongroupVO.setConsumableNumber(countByGroupID);
        }
        eshopCongroupCountVO.setCount(countConsumableNun);
        eshopCongroupCountVO.setEshopCongroupList(eshopCongroups);
        return eshopCongroupCountVO;
    }
}

