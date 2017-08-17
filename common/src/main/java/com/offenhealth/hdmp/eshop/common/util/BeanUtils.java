package com.offenhealth.hdmp.eshop.common.util;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

/**
 * 对象处理工具
 * 
 * @author admin
 *
 */
public class BeanUtils {
	
	/**
	 * 获取指定对象中，属性为null的字段名称
	 * @param source 获取的对象
	 * @return 
	 */
	public static String[] getNullPropertyNames(Object source) {
		return getNullPropertyNames(source,null);
	}

	/**
	 * 获取指定对象中，属性为null的字段名称
	 * @param source 某个对象
	 * @param propertyArray 忽略某些字段(数组)
	 * @return
	 */
	public static String[] getNullPropertyNames(Object source,String [] propertyArray) {
		final BeanWrapper src = new BeanWrapperImpl(source);
		PropertyDescriptor[] pds = src.getPropertyDescriptors();
		Set<String> emptyNames = new HashSet<String>();
		for (PropertyDescriptor pd : pds) {
			if (ArrayUtils.contains(propertyArray, pd.getName() )){
				continue;
			}
			Object srcValue = src.getPropertyValue(pd.getName());
			if (srcValue == null)
				emptyNames.add(pd.getName());
		}
		String[] result = new String[emptyNames.size()];
		return emptyNames.toArray(result);
	}


	/**
	 * 将src指定的源对象属性拷贝到target指定的目标对象中(忽略null值)
	 *
	 * @param src
	 * @param target
	 */
	public static void copyProperties(Object src, Object target) {
		org.springframework.beans.BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
	}
	
	/**
	 * 忽略某些属性进行复制
	 * @param src 原对象
	 * @param target 目标对象
	 * @param propertyArray  不复制的属性字段名称
	 */
	public static void copyProperties(Object src, Object target,String [] propertyArray) {
		org.springframework.beans.BeanUtils.copyProperties(src, target, propertyArray );
	}
}
