/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.model;

/**
 * <p>标题： WxImageMsg</p>
 * <p>
 *    功能描述：
 *    
 * </p>
 * <p>创建日期：2015-7-29 上午9:35:55 </p>
 * <p>作者：YinLei</p>
 * <p>版本：1.0</p>
 */
public class WxImageMsg extends WxMsg {

	private String picUrl;
	private String mediaId;
	
	public WxImageMsg() {
		setMsgType(WxMsgType.image.name());
	}
	
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	
}
