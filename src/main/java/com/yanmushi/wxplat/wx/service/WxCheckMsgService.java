/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.service;

import com.yanmushi.wxplat.wx.model.WxCheckInput;

/**
 * @author YinLei
 * @since 
 */
public interface WxCheckMsgService {

	/**
	 * @param input
	 * @return
	 */
	String check(WxCheckInput input);
}
