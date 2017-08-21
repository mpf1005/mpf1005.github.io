package com.offenhealth.hdmp.eshop.bean.entity;

import java.math.BigDecimal;
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
@ApiModel(value = "EshopGoods",description = "" )
public class EshopGoods   {

	@ApiModelProperty(value  = "")
			@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private String id;
		@ApiModelProperty(value  = "")
		private String code;
		@ApiModelProperty(value  = "")
		private String goodsName;
		@ApiModelProperty(value  = "")
		private BigDecimal price;
		@ApiModelProperty(value  = "")
		private BigDecimal weight;
		@ApiModelProperty(value  = "")
		private Integer goodsNum;
		@ApiModelProperty(value  = "")
		private String goodsPictureIdlist;
		@ApiModelProperty(value  = "")
		private Integer amount;
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
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置：
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	/**
	 * 获取：
	 */
	public String getGoodsName() {
		return goodsName;
	}
	/**
	 * 设置：
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * 设置：
	 */
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getWeight() {
		return weight;
	}
	/**
	 * 设置：
	 */
	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}
	/**
	 * 获取：
	 */
	public Integer getGoodsNum() {
		return goodsNum;
	}
	/**
	 * 设置：
	 */
	public void setGoodsPictureIdlist(String goodsPictureIdlist) {
		this.goodsPictureIdlist = goodsPictureIdlist;
	}
	/**
	 * 获取：
	 */
	public String getGoodsPictureIdlist() {
		return goodsPictureIdlist;
	}
	/**
	 * 设置：
	 */
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	/**
	 * 获取：
	 */
	public Integer getAmount() {
		return amount;
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
