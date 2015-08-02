/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.service.impl;

import com.yanmushi.wxplat.wx.model.WxMsgInput;
import com.yanmushi.wxplat.wx.service.WxEncryptResolver;

/**
 * 通过直接明文的方式处理消息
 * @author YinLei
 * @since 
 */
public class WxEnccryptDirectResolver implements WxEncryptResolver {

	@Override
	public String decode(String msg, WxMsgInput input) {
		return msg;
	}

	@Override
	public String encode(String msg, WxMsgInput input) {
		return msg;
	}

}
