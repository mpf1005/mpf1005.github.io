package com.offenhealth.hdmp.eshop.business.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.offenhealth.hdmp.eshop.bean.entity.EshopConPro;
import com.offenhealth.hdmp.eshop.bean.entity.EshopConsumable;
import com.offenhealth.hdmp.eshop.bean.entity.EshopConsumableGroup;
import com.offenhealth.hdmp.eshop.bean.entity.EshopOutput;
import com.offenhealth.hdmp.eshop.bean.vo.EshopConsumableVO;
import com.offenhealth.hdmp.eshop.business.base.BaseService;
import com.offenhealth.hdmp.eshop.business.base.IBaseDao;
import com.offenhealth.hdmp.eshop.business.dao.EshopConProMapper;
import com.offenhealth.hdmp.eshop.business.dao.EshopConsumableGroupMapper;
import com.offenhealth.hdmp.eshop.business.dao.EshopConsumableMapper;
import com.offenhealth.hdmp.eshop.business.dao.EshopOutputMapper;
import com.offenhealth.hdmp.eshop.business.service.EshopConsumableService;
import com.offenhealth.hdmp.eshop.common.constants.ResultCode;
import com.offenhealth.hdmp.eshop.common.exception.ServiceException;
import com.offenhealth.hdmp.eshop.common.util.UserUtil;
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
@Service("eshopConsumableService")
@Transactional
public class EshopConsumableServiceImpl extends BaseService<EshopConsumable,String> implements EshopConsumableService  {

    @Autowired
    private EshopConsumableMapper eshopConsumableMapper;
    @Autowired
    private EshopConsumableGroupMapper eshopConsumableGroupMapper;
    @Autowired
    private EshopConProMapper eshopConProMapper;
    @Autowired
    private EshopOutputMapper eshopOutputMapper;
    @Override
    protected IBaseDao <EshopConsumable> getBaseDao() {
        return eshopConsumableMapper;
    }

    /*
*@Author:johnson
*@Description:新增耗材
*@Date:18:57 2017/8/21
*/
    @Override
    public int insertConsumable(EshopConsumableVO eshopConsumableVO) {
        int insert = 0;
        if (eshopConsumableVO!=null){
        try {
            eshopConsumableVO.setCode("11011661");
            eshopConsumableVO.setStatus("2");
            eshopConsumableVO.setCreateUser(UserUtil.getuser());
            eshopConsumableVO.setCreateTime(new Date());
            eshopConsumableVO.setLastMTime(new Date());
            eshopConsumableVO.setLastMUser(UserUtil.getuser());
            insert = eshopConsumableMapper.insert(eshopConsumableVO);
            if (eshopConsumableVO.getGroupIdList()!=null){
                String[] consumableGroupIds = eshopConsumableVO.getGroupIdList();
                for (String id:consumableGroupIds) {
                    EshopConsumableGroup eshopConsumableGroup = new EshopConsumableGroup();
                    eshopConsumableGroup.setStatus("1");
                    eshopConsumableGroup.setCreateTime(new Date());
                    eshopConsumableGroup.setCreateUser(UserUtil.getuser());
                    eshopConsumableGroup.setLastMTime(new Date());
                    eshopConsumableGroup.setLastMUser(UserUtil.getuser());
                    eshopConsumableGroup.setConId(eshopConsumableVO.getId());
                    eshopConsumableGroup.setGroupId(id);
                    eshopConsumableGroupMapper.insert(eshopConsumableGroup);
                }
            }

        } catch (Exception e) {
            throw new ServiceException(ResultCode.PARAM_ERROR.getCode(),ResultCode.PARAM_ERROR.getMsg());
        }
        }
        return insert;
    }


    /*
  *@Author:johnson
  *@Description:更新耗材
  *@Date:10:06 2017/8/22
  */

    public int updateConsumable(EshopConsumableVO eshopConsumableVO){
        int i=0;
        EshopConsumableGroup eshopConsumableGroup=null;
        if (eshopConsumableVO!=null){
            i = eshopConsumableMapper.updateByPrimaryKey(eshopConsumableVO);
            if (eshopConsumableVO.getGroupIdList()!=null) {
                String[] consumableGroupIds = eshopConsumableVO.getGroupIdList();
                List<EshopConsumableGroup> eshopConsumableGroups = eshopConsumableGroupMapper.selectConsGroupByConId(eshopConsumableVO.getId());//根据id查询耗材分组列表
                if (eshopConsumableGroups!=null) {
                    for (EshopConsumableGroup eshopConsGroup : eshopConsumableGroups) {
                        eshopConsumableGroupMapper.deleteByPrimaryKey(eshopConsGroup);
                    }
                    for (String id : consumableGroupIds) {
                        eshopConsumableGroup = new EshopConsumableGroup();
                        eshopConsumableGroup.setStatus("1");
                        eshopConsumableGroup.setCreateTime(new Date());
                        eshopConsumableGroup.setCreateUser(UserUtil.getuser());
                        eshopConsumableGroup.setLastMTime(new Date());
                        eshopConsumableGroup.setLastMUser(UserUtil.getuser());
                        eshopConsumableGroup.setConId(eshopConsumableVO.getId());
                        eshopConsumableGroup.setGroupId(id);
                        eshopConsumableGroupMapper.insert(eshopConsumableGroup);
                    }
                }
            }
        }
        return i;
    }




    /* *@Author:johnson
     *@Description:查找特定耗材
     *@Date:13:53 2017/8/22*/
    @Override
    public EshopConsumableVO queryConsumablesInfo(String id){
        EshopConsumableVO eshopConsumable = eshopConsumableMapper.queryConsumablesInfo(id);
        return eshopConsumable;
    }


    @Override
    public PageInfo<EshopConsumableVO> pageList(int pageNum, int pageSize, String search) {
        PageHelper.startPage(pageNum, pageSize);
        List<EshopConsumableVO> list = eshopConsumableMapper.pageList(search);//查出所有的耗材
        //遍历耗材列表 将查到的已用信息设置进去
        for (EshopConsumableVO eshopConsumableVO:list) {
            //根据耗材Id去出库表中查询记录
            EshopOutput eshopOutput = eshopOutputMapper.selectUsedCountByConId(eshopConsumableVO.getId());
            //如果出库表没有这个记录 将已用数量设置成0返回
            if (eshopOutput==null){
                eshopConsumableVO.setUsedCount(0);
            }else {
                eshopConsumableVO.setUsedCount(eshopOutput.getUsedCount());
            }
        }
        PageInfo <EshopConsumableVO> pageInfo = new PageInfo <>(list);
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
