/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.model;

/**
 *
 * @author YinLei
 * @since 1.0
 */
public class WxAccessToken {

	private String accessToken;
	private long expiresIn;
	private long createTime = System.currentTimeMillis();

	/**
	 * 返回当前的token是否有效
	 * @return
	 */
	public boolean isActive() {
		return System.currentTimeMillis() - createTime < expiresIn;
	}
	
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public long getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(long expiresIn) {
		this.expiresIn = expiresIn * 1000;
	}
}
