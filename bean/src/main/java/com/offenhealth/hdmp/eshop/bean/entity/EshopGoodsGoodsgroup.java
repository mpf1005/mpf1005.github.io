package com.offenhealth.hdmp.eshop.bean.entity;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



/**
 * 
 * 
 * @author hhy
 * @date 2017-08-21 15:36:33
 */
@ApiModel(value = "EshopGoodsGoodsgroup",description = "" )
public class EshopGoodsGoodsgroup   {

	@ApiModelProperty(value  = "")
			@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private String id;
		@ApiModelProperty(value  = "")
		private String goodsId;
		@ApiModelProperty(value  = "")
		private String goodsGroupId;
		@ApiModelProperty(value  = "")
		private String description;
		@ApiModelProperty(value  = "")
		private String status;
		@ApiModelProperty(value  = "")
		private String createUser;
		@ApiModelProperty(value  = "")
		private Date createTime;
		@ApiModelProperty(value  = "")
		private String lastMUser;
		@ApiModelProperty(value  = "")
		private Date lastMTime;
		@ApiModelProperty(value  = "")
		private String version;
	
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
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	/**
	 * 获取：
	 */
	public String getGoodsId() {
		return goodsId;
	}
	/**
	 * 设置：
	 */
	public void setGoodsGroupId(String goodsGroupId) {
		this.goodsGroupId = goodsGroupId;
	}
	/**
	 * 获取：
	 */
	public String getGoodsGroupId() {
		return goodsGroupId;
	}
	/**
	 * 设置：
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置：
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：
	 */
	public void setLastMUser(String lastMUser) {
		this.lastMUser = lastMUser;
	}
	/**
	 * 获取：
	 */
	public String getLastMUser() {
		return lastMUser;
	}
	/**
	 * 设置：
	 */
	public void setLastMTime(Date lastMTime) {
		this.lastMTime = lastMTime;
	}
	/**
	 * 获取：
	 */
	public Date getLastMTime() {
		return lastMTime;
	}
	/**
	 * 设置：
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * 获取：
	 */
	public String getVersion() {
		return version;
	}
}
