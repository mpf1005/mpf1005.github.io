package com.offenhealth.hdmp.eshop.business.service.impl;


import com.offenhealth.hdmp.eshop.bean.entity.EshopProjectGroup;
import com.offenhealth.hdmp.eshop.bean.vo.EshopProjectVO;
import com.offenhealth.hdmp.eshop.business.service.EshopProjectGroupService;
import com.offenhealth.hdmp.eshop.common.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.offenhealth.hdmp.eshop.business.base.BaseService;
import com.offenhealth.hdmp.eshop.business.base.IBaseDao;
import com.offenhealth.hdmp.eshop.business.service.EshopProjectService;
import com.offenhealth.hdmp.eshop.business.dao.EshopProjectMapper;
import com.offenhealth.hdmp.eshop.bean.entity.EshopProject;
import java.util.Date;
import java.util.List;



/**
 * 
 *
 * @author hhy
 * @date 2017-08-18 16:57:44
 */
@Service("eshopProjectService")
@Transactional
public class EshopProjectServiceImpl extends BaseService<EshopProject,String> implements EshopProjectService  {

	@Autowired
	private EshopProjectMapper eshopProjectMapper;

    @Autowired
    private EshopProjectGroupService eshopProjectGroupService;


    @Override
    protected IBaseDao <EshopProject> getBaseDao() {
        return eshopProjectMapper;
    }

    /**
     * 分页
     * @param pageNum   页码
     * @param pageSize  页数
     * @param search  搜索内容
     * @return PageInfo 分页信息
     */
    @Override
    public PageInfo<EshopProject> pageList(int pageNum, int pageSize, String search) {
        PageHelper.startPage(pageNum, pageSize);
        List<EshopProject> list = eshopProjectMapper.pageList(search);
        PageInfo <EshopProject> pageInfo = new PageInfo <>(list);
        return pageInfo;
    }

    @Override
    public int insert(EshopProjectVO eshopProjectVO) {
        int project=0;//初始化
        String getuser = UserUtil.getuser();//获取当前用户
        String[] groupIdList = eshopProjectVO.getGroupIdList();
        eshopProjectVO.setCode("1");//添加编号
        eshopProjectVO.setStatus("1");//添加状态
        eshopProjectVO.setCreateUser(getuser);//添加当前用户
        eshopProjectVO.setCreateTime(new Date());//创建时间
        eshopProjectVO.setLastMUser(getuser);//添加最后修改人
        eshopProjectVO.setLastMTime(new Date());//最后修改时间
        project = eshopProjectMapper.insert(eshopProjectVO);//添加项目
        if(groupIdList!=null){
            for(String gl:groupIdList){
                EshopProjectGroup eshopProjectGroup = new EshopProjectGroup();
                eshopProjectGroup.setProjectId(eshopProjectVO.getId());
                eshopProjectGroup.setGroupId(gl);
                eshopProjectGroup.setStatus("1");//添加状态
                eshopProjectGroup.setCreateUser(getuser);//添加当前用户
                eshopProjectGroup.setCreateTime(new Date());//创建时间
                eshopProjectGroup.setLastMUser(getuser);//添加最后修改人
                eshopProjectGroup.setLastMTime(new Date());//最后修改时间
                eshopProjectGroupService.insert(eshopProjectGroup);
            }
        }
        return project;
    }

    /**
     * 批量删除
     * @param ids   id数组
     */
    @Override
    public void deleteBatch(String [] ids){
        eshopProjectMapper.deleteBatch(ids);
    }
}
