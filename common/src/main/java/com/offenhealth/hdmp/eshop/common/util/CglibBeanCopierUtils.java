package com.offenhealth.hdmp.eshop.common.util;

import net.sf.cglib.beans.BeanCopier;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/10.
 */
public class CglibBeanCopierUtils {

    /**
     *
     */
    public static Map<String, BeanCopier> beanCopierMap = new HashMap< >();

    /**
     * @Title: copyProperties
     * @Description: TODO(bean属性转换)
     * @param source 资源类
     * @param target  目标类
     */
    public static void copyProperties(Object source,Object target){
        String beanKey = generateKey(source.getClass(),target.getClass());
        BeanCopier copier = null;
        if (!beanCopierMap.containsKey(beanKey)) {
            copier = BeanCopier.create(source.getClass(), target.getClass(), false);
            beanCopierMap.put(beanKey, copier);
        }else {
            copier = beanCopierMap.get(beanKey);
        }
        copier.copy(source, target, null);
    }
    private static String generateKey(Class<?>class1,Class<?>class2){
        return class1.toString() + class2.toString();
    }


}
