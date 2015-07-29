/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.service;

import java.io.InputStream;

import com.yanmushi.wxplat.wx.model.WxMsg;

/**
 * 主要解析用户的消息并完成消息的加密与解密
 * @author YinLei
 * @since 1.0
 */
public interface WxEncryptService {

	WxMsg decode(InputStream in);
	
	String encode(WxMsg msg);
}
