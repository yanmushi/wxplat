/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.service;

import com.yanmushi.wxplat.wx.model.WxMsgInput;


/**
 * 主要解析用户的消息并完成消息的加密与解密
 * @author YinLei
 * @since 1.0
 */
public interface WxEncryptResolver {

	/**
	 * 解密消息
	 * @param msg 消息内容
	 * @param input 上下文信息
	 * @return 解码后的字符串
	 */
	String decode(String msg, WxMsgInput input);
	
	/**
	 * 加密消息
	 * @param msg 消息内容
	 * @param input 上下文消息
	 * @return 加密后的字符串
	 */
	String encode(String msg, WxMsgInput input);
}
