package com.offenhealth.hdmp.eshop.bean.vo;

import com.offenhealth.hdmp.eshop.bean.entity.EshopCongroup;

/**
 * Created by hasee on 2017/8/21.
 */
public class EshopCongroupVO extends EshopCongroup {
    //这个分组下的耗材数量
    private int consumableNumber;

    public int getConsumableNumber() {
        return consumableNumber;
    }

    public void setConsumableNumber(int consumableNumber) {
        this.consumableNumber = consumableNumber;
    }
}
