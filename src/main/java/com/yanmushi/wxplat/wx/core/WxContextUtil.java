/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.core;

import com.yanmushi.wxplat.wx.model.WxMsgInput;

/**
 * 获取上下文的工具类
 * @author YinYan
 * @since 
 */
public class WxContextUtil {

	private static WxContext context;

	private static ThreadLocal<WxMsgInput> msgInput = 
			new ThreadLocal<WxMsgInput>();
	
	public static WxMsgInput getMsgInput() {
		return msgInput.get();
	}
	
	public static void setMsgInput(WxMsgInput input) {
		msgInput.set(input);
	}
	
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
