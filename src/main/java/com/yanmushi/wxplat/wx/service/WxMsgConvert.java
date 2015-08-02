/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.service;

import com.yanmushi.wxplat.wx.model.WxMsg;
import com.yanmushi.wxplat.wx.model.WxMsgInput;

/**
 * @author YinLei
 * @since 
 */
public interface WxMsgConvert {

	/**
	 * 将微信端输入的信息转换为业务对象
	 * @param msg
	 * @return
	 */
	WxMsg convert(String msg, WxMsgInput input);
}
