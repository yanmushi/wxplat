/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.core.impl;

import com.yanmushi.wxplat.wx.core.WxContext;

/**
 * 
 *
 * @author YinLei
 * @since 1.0
 */
public class WxContextImpl implements WxContext {

	private String token;
	private String aesKey;
	private String appId;
	private String appSecret;

	@Override
	public String getToken() {
		return this.token;
	}

	public String getAesKey() {
		return aesKey;
	}

	public String getAppId() {
		return appId;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAesKey(String aesKey) {
		this.aesKey = aesKey;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
