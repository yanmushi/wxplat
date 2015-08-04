/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.core.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.yanmushi.utils.JsonUtils;
import com.yanmushi.wxplat.wx.core.WxAccessTokenLoader;
import com.yanmushi.wxplat.wx.exception.WxConnectException;
import com.yanmushi.wxplat.wx.model.WxAccessToken;

/**
 *
 * @author YinLei
 * @since 1.0
 */
public class UrlWxAccessTokenLoader implements WxAccessTokenLoader {

	private String appid;
	private String secret;
	private String link = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=";
	
	@Override
	public WxAccessToken load() {
		WxAccessToken token = null;
		try {
			URL url = new URL(link.replaceFirst("APPID", appid) + secret);
			URLConnection con = url.openConnection();
			con.setReadTimeout(1000);
			
			String json = IOUtils.toString(con.getInputStream());
			
			Map<String, Object> map = JsonUtils.parse2Map(json);
			String accessToken = (String) map.get("access_token");
			if (accessToken != null) {
				token = new WxAccessToken();
				token.setAccessToken(accessToken);
				token.setExpiresIn(Long.valueOf(map.get("expires_in").toString()));
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (JsonParseException | JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			throw new WxConnectException("微信token获取失败", e);
		}
		
		return token;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}
}
