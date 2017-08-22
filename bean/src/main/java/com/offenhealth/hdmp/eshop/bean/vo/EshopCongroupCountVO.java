package com.offenhealth.hdmp.eshop.bean.vo;

import java.util.List;

/** 耗材分组展示需要
 * Created by hasee on 2017/8/22.
 */

public class EshopCongroupCountVO {
    //全部耗材 耗材类别数量
    private Integer count;
    private List<EshopCongroupVO> EshopCongroupList;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<EshopCongroupVO> getEshopCongroupList() {
        return EshopCongroupList;
    }

    public void setEshopCongroupList(List<EshopCongroupVO> eshopCongroupList) {
        EshopCongroupList = eshopCongroupList;
    }
}
