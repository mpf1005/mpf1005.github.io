package com.offenhealth.hdmp.eshop.bean.vo;

import java.util.List;

/**
 * Created by earl on 2017/3/30.
 */
public class EshopProgroupCountVO {

    private Integer count;

    private List<EshopProgroupVO> eshopProgroupVOS;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<EshopProgroupVO> getEshopProgroupVOS() {
        return eshopProgroupVOS;
    }

    public void setEshopProgroupVOS(List<EshopProgroupVO> eshopProgroupVOS) {
        this.eshopProgroupVOS = eshopProgroupVOS;
    }
}

