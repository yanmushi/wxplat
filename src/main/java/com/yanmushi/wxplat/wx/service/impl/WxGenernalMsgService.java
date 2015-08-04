/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.service.impl;

import com.yanmushi.wxplat.wx.core.WxContextUtil;
import com.yanmushi.wxplat.wx.model.WxMsg;
import com.yanmushi.wxplat.wx.model.WxMsgInput;
import com.yanmushi.wxplat.wx.service.WxMsgFormatter;
import com.yanmushi.wxplat.wx.service.WxMsgHandler;
import com.yanmushi.wxplat.wx.service.WxRecivedMsgService;

/**
 * @author YinYan
 * @since 
 */
public class WxGenernalMsgService implements WxRecivedMsgService {
	
	private WxMsgFormatter wxMsgFormatter;
	private WxMsgHandler wxMsgHandler;
	
	@Override
	public String recived(WxMsgInput input) {
		WxContextUtil.setMsgInput(input);
		
		WxMsg model = wxMsgFormatter.parse();
		
		WxMsg resp = wxMsgHandler.handle(model);
		
		if (resp == null) {
			// 如果没有回复消息，则返回【空白】
			return "";
		}
		
		return wxMsgFormatter.format(resp);
	}

	public WxMsgFormatter getWxMsgFormatter() {
		return wxMsgFormatter;
	}

	public void setWxMsgFormatter(WxMsgFormatter wxMsgFormatter) {
		this.wxMsgFormatter = wxMsgFormatter;
	}

	public WxMsgHandler getWxMsgHandler() {
		return wxMsgHandler;
	}

	public void setWxMsgHandler(WxMsgHandler wxMsgHandler) {
		this.wxMsgHandler = wxMsgHandler;
	}
	
}
