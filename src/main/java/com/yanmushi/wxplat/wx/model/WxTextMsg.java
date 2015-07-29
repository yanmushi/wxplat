/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.model;

/**
 * <p>标题： WxTextMsg</p>
 * <p>
 *    功能描述：
 *    
 * </p>
 * <p>创建日期：2015-7-29 上午9:29:48 </p>
 * <p>作者：YinLei</p>
 * <p>版本：1.0</p>
 */
public class WxTextMsg extends WxMsg {

	public WxTextMsg() {
		setMsgType(WxMsgType.text.name());
	}
	
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
