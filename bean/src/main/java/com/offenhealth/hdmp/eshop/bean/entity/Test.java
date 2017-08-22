package com.offenhealth.hdmp.eshop.bean.entity;

import java.util.Date;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


/**
 * 
 * 
 * @author hhy
 * @date 2017-08-17 15:35:21
 */
@ApiModel(value = "Test",description = "" )
public class Test   {

	@ApiModelProperty(value  = "")
			@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private String id;
		@ApiModelProperty(value  = "")
		@NotNull
		private String name;

		@ApiModelProperty(dataType="string", value = "json" )
		private JSONObject jon;
	
	/**
	 * 设置：
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setJon(JSONObject jon) {
		this.jon = jon;
	}
	/**
	 * 获取：
	 */
	public JSONObject getJon() {
		return jon;
	}
}
