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
 * @date 2017-08-24 13:44:59
 */
@ApiModel(value = "EshopService",description = "" )
public class EshopService   {

	@ApiModelProperty(value  = "")
			@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private String id;
		@ApiModelProperty(value  = "")
		private String code;
		@ApiModelProperty(value  = "")
		private String name;
		@ApiModelProperty(value  = "")
		private BigDecimal price;
		@ApiModelProperty(value  = "")
		private String groupid;
		@ApiModelProperty(value  = "")
		private Integer buyDays;
		@ApiModelProperty(value  = "")
		private Date exporeDate;
		@ApiModelProperty(value  = "")
		private String validityStatus;
		@ApiModelProperty(value  = "")
		private String pictureIdlist;
		@ApiModelProperty(value  = "")
		private String details;
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
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	/**
	 * 获取：
	 */
	public String getGroupid() {
		return groupid;
	}
	/**
	 * 设置：
	 */
	public void setBuyDays(Integer buyDays) {
		this.buyDays = buyDays;
	}
	/**
	 * 获取：
	 */
	public Integer getBuyDays() {
		return buyDays;
	}
	/**
	 * 设置：
	 */
	public void setExporeDate(Date exporeDate) {
		this.exporeDate = exporeDate;
	}
	/**
	 * 获取：
	 */
	public Date getExporeDate() {
		return exporeDate;
	}
	/**
	 * 设置：
	 */
	public void setValidityStatus(String validityStatus) {
		this.validityStatus = validityStatus;
	}
	/**
	 * 获取：
	 */
	public String getValidityStatus() {
		return validityStatus;
	}
	/**
	 * 设置：
	 */
	public void setPictureIdlist(String pictureIdlist) {
		this.pictureIdlist = pictureIdlist;
	}
	/**
	 * 获取：
	 */
	public String getPictureIdlist() {
		return pictureIdlist;
	}
	/**
	 * 设置：
	 */
	public void setDetails(String details) {
		this.details = details;
	}
	/**
	 * 获取：
	 */
	public String getDetails() {
		return details;
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
