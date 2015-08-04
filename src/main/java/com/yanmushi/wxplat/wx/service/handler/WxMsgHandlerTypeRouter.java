/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.service.handler;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import com.yanmushi.wxplat.wx.model.WxMsg;
import com.yanmushi.wxplat.wx.service.WxMsgHandler;

/**
 *
 * @author YinLei
 * @since 1.0
 */
public class WxMsgHandlerTypeRouter implements WxMsgHandler, InitializingBean {

	private static final Logger LOGGER = LoggerFactory.getLogger(WxMsgHandlerTypeRouter.class);
	
	private Map<String, WxMsgHandler> handlerMap = new HashMap<String, WxMsgHandler>();
	private WxMsgHandler defaultHandler;
	
	@Override
	public WxMsg handle(WxMsg msg) {
		String type = msg.getMsgType();
		WxMsgHandler handler = handlerMap.get(type);
		if (handler == null) {
			return defaultHandler.handle(msg);
		}
		try {
			return handler.handle(msg);
		} catch (Exception e) {
			LOGGER.error("数据处理异常", e);
		}
		return defaultHandler.handle(msg);
	}

	public Map<String, WxMsgHandler> getHandlerMap() {
		return handlerMap;
	}

	public void setHandlerMap(Map<String, WxMsgHandler> handlerMap) {
		this.handlerMap = handlerMap;
	}

	public WxMsgHandler getDefaultHandler() {
		return defaultHandler;
	}

	public void setDefaultHandler(WxMsgHandler defaultHandler) {
		this.defaultHandler = defaultHandler;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (defaultHandler == null) {
			defaultHandler = new SimpleWxTextMsgHandler();
		}
	}

}
