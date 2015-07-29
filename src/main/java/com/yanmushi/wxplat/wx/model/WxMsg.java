/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.model;

/**
 * <p>标题： WxMsg</p>
 * <p>
 *    功能描述：
 *    
 * </p>
 * <p>创建日期：2015-7-29 上午9:03:56 </p>
 * <p>作者：YinLei</p>
 * <p>版本：1.0</p>
 */
public class WxMsg {

	private String toUserName;    // 接收人
	private String fromUserName;  // 发送人
	private String createTime;      // 创建时间
	private String msgType;       // 消息类型
	private String msgId;         // 消息ID
	
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getMsgType() {
		return msgType;
	}
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	
	protected void setMsgType(String mt) {
		this.msgType = mt;
	}
}
