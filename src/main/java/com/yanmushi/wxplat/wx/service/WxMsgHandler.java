/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.service;

import com.yanmushi.wxplat.wx.model.WxMsg;

/**
 *
 * @author YinLei
 * @since 1.0
 */
public interface WxMsgHandler {

	/**
	 * 处理消息业务，并将业务结果通过消息的形式返回
	 * @param msg
	 * @return
	 */
	WxMsg handle(WxMsg msg);
}
