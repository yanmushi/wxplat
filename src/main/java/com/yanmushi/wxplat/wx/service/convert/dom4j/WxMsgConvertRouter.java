/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.service.convert.dom4j;

import java.io.StringReader;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.yanmushi.wxplat.wx.model.WxMsg;
import com.yanmushi.wxplat.wx.model.WxMsgInput;
import com.yanmushi.wxplat.wx.service.WxMsgConvert;

/**
 * @author YinLei
 * @since 1.0
 */
public class WxMsgConvertRouter implements WxMsgConvert, ApplicationContextAware {

	private Map<String, WxMsgConvert> convertMap;
	
	@Override
	public WxMsg convert(String msg, WxMsgInput input) {
		WxMsg wxMsg = null;
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(new StringReader(msg));
			Element root = doc.getRootElement();
			String  msgType = root.elementText("MsgType");
			
			WxMsgDom4jConvertHolder.set(root);
			
			wxMsg = convertMap.get(msgType).convert(msgType, input);
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return wxMsg;
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		// TODO Auto-generated method stub
		
	}

}
