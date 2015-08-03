/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.service.impl;

import java.io.InputStream;

import com.yanmushi.wxplat.wx.model.WxMsg;
import com.yanmushi.wxplat.wx.model.WxMsgInput;
import com.yanmushi.wxplat.wx.service.WxEncryptResolver;
import com.yanmushi.wxplat.wx.service.WxMsgConvert;
import com.yanmushi.wxplat.wx.service.WxMsgReader;

/**
 * @author YinLei
 * @since 
 */
public class WxMsgReaderImpl implements WxMsgReader {

	private WxEncryptResolver wxEncryptResolver;
	private WxMsgConvert wxMsgConvert;
	
	@Override
	public WxMsg read(WxMsgInput input) {
		InputStream msg = input.getIn();
		String s = getFromStream(msg);
		String unencryptMsg = wxEncryptResolver.decode(s, input);
		
		return wxMsgConvert.convert(unencryptMsg, input);
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
