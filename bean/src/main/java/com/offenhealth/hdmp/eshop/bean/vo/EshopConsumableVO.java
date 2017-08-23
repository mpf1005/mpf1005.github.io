package com.offenhealth.hdmp.eshop.bean.vo;

import com.offenhealth.hdmp.eshop.bean.entity.EshopCongroup;
import com.offenhealth.hdmp.eshop.bean.entity.EshopConsumable;

import javax.persistence.Transient;
import java.util.List;

/**
 * Created by hasee on 2017/8/21.
 */
public class EshopConsumableVO extends EshopConsumable {
    //耗材分组表ID集合
    @Transient
    private String[] groupIdList;
    @Transient
    private List<EshopCongroup> eshopCongroup;
    //已用数量
    private  Integer usedCount;

    public Integer getUsedCount() {
        return usedCount;
    }

    public void setUsedCount(Integer usedCount) {this.usedCount = usedCount;}

    public List<EshopCongroup> getEshopCongroup() {
        return eshopCongroup;
    }

    public void setEshopCongroup(List<EshopCongroup> eshopCongroup) {
        this.eshopCongroup = eshopCongroup;
    }

    public String[] getGroupIdList() {
        return groupIdList;
    }

    public void setGroupIdList(String[] groupIdList) {
        this.groupIdList = groupIdList;
    }
}
