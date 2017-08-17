package com.offenhealth.hdmp.eshop.business.typehandler;

import com.google.common.collect.Maps;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * 星期信息
 *
 * @author wenqiang.luo date:16/1/25
 */
public enum DayType {

    SUNDAY(0, "周日"),

    MONDAY(1, "周一"),

    TUESDAY(2, "周二"),

    WEDNESDAY(3, "周三"),

    THURSDAY(4, "周四"),

    FRIDAY(5, "周五"),

    SATURDAY(6, "周六");

    private int type;

    private String name;

    DayType(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return this.name;
    }

    public static DayType typeOf(int type) {
        DayType[] dayTypes = values();
        for(DayType dayType : dayTypes) {
            if(dayType.getType() == type) {
                return dayType;
            }
        }
        throw new IllegalArgumentException("Invalid DayType Type: " + type);
    }

    public static Map<Integer, String> convertToMap() {
        Map<Integer, String> map = Maps.newLinkedHashMap();
        for(DayType dayType : DayType.values()) {
            map.put(dayType.getType(), dayType.getName());
        }
        return map;
    }

    public static DayType weekOf(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return typeOf((calendar.get(Calendar.DAY_OF_WEEK) - 1) % 7);
    }

}