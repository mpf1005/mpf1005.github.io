package com.offenhealth.hdmp.eshop.common.util;

/**
 * Created by Administrator on 2017/8/15 0015.
 */
public class Userutil {

    /**
     * 获取当前登录用户
     * @return name +toles
     */
    public static  String getuser() {
        /*String name =  SecurityContextHolder.getContext().getAuthentication().getName();
        String toles = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
        return name+" "+toles;*/
        String name="张三";
        return name;
    }
}
