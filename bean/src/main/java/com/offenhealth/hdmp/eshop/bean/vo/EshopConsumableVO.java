package com.offenhealth.hdmp.eshop.bean.vo;

import com.offenhealth.hdmp.eshop.bean.entity.EshopCongroup;
import com.offenhealth.hdmp.eshop.bean.entity.EshopConsumable;

import javax.persistence.Transient;

/**
 * Created by hasee on 2017/8/21.
 */
public class EshopConsumableVO extends EshopConsumable {
    //耗材分组表ID集合
    @Transient
    private String[] consumableGroupIds;



    public String[] getConsumableGroupIds() {
        return consumableGroupIds;
    }

    public void setConsumableGroupIds(String[] consumableGroupIds) {
        this.consumableGroupIds = consumableGroupIds;
    }
}
