/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.core;

import com.yanmushi.wxplat.wx.model.WxMsgInput;

/**
 * @author YinLei
 * @since 
 */
public class WxContextHolder {

	private static ThreadLocal<WxMsgInput> msgContext = 
			new ThreadLocal<WxMsgInput>();
	
	public static WxMsgInput getMsgContext() {
		return msgContext.get();
	}
	
	public static void setMsgContext(WxMsgInput input) {
		msgContext.set(input);
	}
}
