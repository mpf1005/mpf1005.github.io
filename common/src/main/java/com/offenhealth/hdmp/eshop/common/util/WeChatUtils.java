package com.offenhealth.hdmp.eshop.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 微信工具类
 * @author zhongbojie
 */
public class WeChatUtils {
	
	/**
	 * 报名模板消息key
	 */
	public static final String TEMPLATE_REGISTER ="template_register";

	//防止被实例化引用
	private WeChatUtils(){ }
	

    /**
     * 获取微信表的json配置的某个key的值
     * @param jsonData 微信配置json字符串
     * @param key  某个key
     * @return key对应的值
     */ 
    public static String getValue(String jsonData,String key) {
		JSONObject jsonObj =  JSON.parseObject(jsonData);
		if (jsonObj == null ) {
			return null;
		}
    	return  jsonObj.get(key).toString();
    }

}
