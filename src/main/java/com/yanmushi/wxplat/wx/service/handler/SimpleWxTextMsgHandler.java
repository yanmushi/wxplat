/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.service.handler;

import com.yanmushi.wxplat.wx.model.WxMsg;
import com.yanmushi.wxplat.wx.model.WxTextMsg;
import com.yanmushi.wxplat.wx.service.WxMsgHandler;

/**
 *
 * @author YinLei
 * @since 1.0
 */
public class SimpleWxTextMsgHandler implements WxMsgHandler {

	private static final String DEFAULT_CONTENT = "您的问题我们已经收集，感谢您的参与！";
	
	private String content = DEFAULT_CONTENT;
	
	@Override
	public WxMsg handle(WxMsg msg) {
		WxTextMsg resp = new WxTextMsg();
		
		resp.setContent(content);
		resp.setFromUserName(msg.getToUserName());
		resp.setToUserName(msg.getFromUserName());
		resp.setCreateTime(msg.getCreateTime());
		
		return resp;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
