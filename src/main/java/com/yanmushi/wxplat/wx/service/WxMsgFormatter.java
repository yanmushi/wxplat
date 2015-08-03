/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.service;

import com.yanmushi.wxplat.wx.model.WxMsg;

/**
 * @author YinLei
 * @since 
 */
public interface WxMsgFormatter {

	WxMsg parse();
	
	String format(WxMsg msg);
}
