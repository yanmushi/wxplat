/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.core;

/**
 * <p>标题： WxContext</p>
 * <p>
 *    功能描述：
 *    
 * </p>
 * <p>创建日期：2015-7-29 上午11:31:24 </p>
 * <p>作者：YinLei</p>
 * <p>版本：1.0</p>
 */
public interface WxContext {

	String getToken();
	
	String getAesKey();
	
	String getAppId();
	
	String getAppSecret();
}
