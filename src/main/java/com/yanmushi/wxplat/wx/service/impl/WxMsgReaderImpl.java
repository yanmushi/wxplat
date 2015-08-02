/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.service.impl;

import java.io.InputStream;
import java.io.StringReader;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.yanmushi.wxplat.wx.model.WxMsg;
import com.yanmushi.wxplat.wx.model.WxMsgInput;
import com.yanmushi.wxplat.wx.service.WxEncryptResolver;
import com.yanmushi.wxplat.wx.service.WxMsgReader;

/**
 * @author YinLei
 * @since 
 */
public class WxMsgReaderImpl implements WxMsgReader {

	private WxEncryptResolver wxEncryptResolver;
	
	@Override
	public WxMsg read(WxMsgInput input) {
		InputStream msg = input.getIn();
		String s = getFromStream(msg);
		String unencryptMsg = wxEncryptResolver.decode(s, input);
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(new StringReader(unencryptMsg));
			Element root = doc.getRootElement();
			String  msgType = root.elementText("MsgType");
			
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param msg
	 * @return
	 */
	private String getFromStream(InputStream msg) {
		// TODO 将流转换为字符串
		return "";
	}

}
