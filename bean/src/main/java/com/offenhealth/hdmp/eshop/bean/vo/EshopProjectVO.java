package com.offenhealth.hdmp.eshop.bean.vo;

import com.offenhealth.hdmp.eshop.bean.entity.EshopConsumable;
import com.offenhealth.hdmp.eshop.bean.entity.EshopProject;

import java.util.List;

/**
 * Created by earl on 2017/3/30.
 */
public class EshopProjectVO extends EshopProject {

    //项目分组
    private String[] groupIdList;
    //耗材
    private List<EshopConsumable> eshopConsumables;

    public String[] getGroupIdList() {
        return groupIdList;
    }

    public void setGroupIdList(String[] groupIdList) {
        this.groupIdList = groupIdList;
    }

    public List<EshopConsumable> getEshopConsumables() {
        return eshopConsumables;
    }

    public void setEshopConsumables(List<EshopConsumable> eshopConsumables) {
        this.eshopConsumables = eshopConsumables;
    }
}

