/*
 * copyrity @ YanMushi 2015
 */
package com.yanmushi.wxplat.plat.model;

import java.util.Date;

/**
 * @author yan.mushi
 * @since 
 */
public class PlatMerchant {

	private Integer id;
	private String mname;
	private Date createTime;
	private String username;
	private String password;
	private String wxKey;
	private String shopName;
	private String shopLogo;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the mname
	 */
	public String getMname() {
		return mname;
	}
	/**
	 * @param mname the mname to set
	 */
	public void setMname(String mname) {
		this.mname = mname;
	}
	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the wxKey
	 */
	public String getWxKey() {
		return wxKey;
	}
	/**
	 * @param wxKey the wxKey to set
	 */
	public void setWxKey(String wxKey) {
		this.wxKey = wxKey;
	}
	/**
	 * @return the shopName
	 */
	public String getShopName() {
		return shopName;
	}
	/**
	 * @param shopName the shopName to set
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	/**
	 * @return the shopLogo
	 */
	public String getShopLogo() {
		return shopLogo;
	}
	/**
	 * @param shopLogo the shopLogo to set
	 */
	public void setShopLogo(String shopLogo) {
		this.shopLogo = shopLogo;
	}
	
}
