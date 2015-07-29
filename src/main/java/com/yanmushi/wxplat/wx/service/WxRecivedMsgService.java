/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.service;

import java.io.InputStream;

/**
 *
 * @author YinLei
 * @since 1.0
 */
public interface WxRecivedMsgService {

	/**
	 * 解析接受到的消息，并返回对应消息的处理结果
	 * @param in
	 * @return
	 */
	String recived(InputStream in);
}
