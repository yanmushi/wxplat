/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.core;

/**
 * 获取上下文的工具类
 * @author YinYan
 * @since 
 */
public class WxContextUtil {

	private static WxContext context;
	
	public static WxContext getContext() {
		return context;
	}
	
	public static void setContext(WxContext context) {
		WxContextUtil.context = context;
	}
	
	public static String getToken() {
		return context.getToken();
	}

	/**
	 * @return
	 */
	public static String getAesKey() {
		return context.getAesKey();
	}

	/**
	 * @return
	 */
	public static String getAppId() {
		return context.getAppId();
	}
}
