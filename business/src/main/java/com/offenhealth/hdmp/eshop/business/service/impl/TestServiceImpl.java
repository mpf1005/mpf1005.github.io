package com.offenhealth.hdmp.eshop.business.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.offenhealth.hdmp.eshop.business.base.BaseService;
import com.offenhealth.hdmp.eshop.business.base.IBaseDao;
import com.offenhealth.hdmp.eshop.business.service.TestService;
import com.offenhealth.hdmp.eshop.business.dao.TestMapper;
import com.offenhealth.hdmp.eshop.bean.entity.Test;
import java.util.List;



/**
 * 
 *
 * @author hhy
 * @date 2017-08-17 15:35:21
 */
@Service("testService")
@Transactional
public class TestServiceImpl extends BaseService<Test,String> implements TestService  {

	@Autowired
	private TestMapper testMapper;


    @Override
    protected IBaseDao <Test> getBaseDao() {
        return testMapper;
    }

    /**
     * 分页
     * @param pageNum   页码
     * @param pageSize  页数
     * @param search  搜索内容
     * @return PageInfo 分页信息
     */
    @Override
    public PageInfo<Test> pageList(int pageNum, int pageSize, String search) {
        PageHelper.startPage(pageNum, pageSize);
        List<Test> list = testMapper.pageList(search);
        PageInfo <Test> pageInfo = new PageInfo <>(list);
        return pageInfo;
    }

    /**
     * 批量删除
     * @param ids   id数组
     */
    @Override
    public void deleteBatch(String [] ids){
        testMapper.deleteBatch(ids);
    }
}
