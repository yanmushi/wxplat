/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.service.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yanmushi.wxplat.wx.model.WxImageMsg;
import com.yanmushi.wxplat.wx.model.WxMsg;
import com.yanmushi.wxplat.wx.model.WxTextMsg;
import com.yanmushi.wxplat.wx.service.WxMsgHandler;

/**
 *
 * @author YinLei
 * @since 1.0
 */
public class CollectImageMsgHandler implements WxMsgHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(CollectImageMsgHandler.class);
	
	@Override
	public WxMsg handle(WxMsg msg) {
		WxImageMsg wim = (WxImageMsg) msg;

		LOGGER.debug("图片信息：USER: {}, IMAGE: {}", msg.getFromUserName(), wim.getMediaId());
		
		WxTextMsg wtm = new WxTextMsg();
		wtm.setToUserName(msg.getFromUserName());
		wtm.setFromUserName(msg.getToUserName());
		wtm.setCreateTime(msg.getCreateTime());
		wtm.setContent("图片信息已经收录，谢谢您的支持");
		return wtm;
	}

}
