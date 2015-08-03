/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.yanmushi.wxplat.exception.PlatExecption;
import com.yanmushi.wxplat.wx.core.WxContextUtil;
import com.yanmushi.wxplat.wx.model.WxMsg;
import com.yanmushi.wxplat.wx.model.WxMsgInput;
import com.yanmushi.wxplat.wx.service.WxEncryptResolver;
import com.yanmushi.wxplat.wx.service.WxMsgConvert;
import com.yanmushi.wxplat.wx.service.WxMsgFormatter;

/**
 * @author YinLei
 * @since 
 */
public class WxMsgFormatterImpl implements WxMsgFormatter {

	private WxEncryptResolver wxEncryptResolver;
	private WxMsgConvert wxMsgConvert;

	/**
	 * @param msg
	 * @return
	 */
	private String getFromStream(InputStream msg) {
		BufferedReader br = new BufferedReader(new InputStreamReader(msg));
		StringBuffer sb = new StringBuffer();
		String line = null;
		try {
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			throw new PlatExecption(e);
		}
		return sb.toString();
	}

	@Override
	public WxMsg parse() {
		WxMsgInput input = WxContextUtil.getMsgInput();
		InputStream msg = input.getIn();
		String s = getFromStream(msg);
		String unencryptMsg = wxEncryptResolver.decode(s, input);
		
		return wxMsgConvert.convert2Model(unencryptMsg, input);
	}

	@Override
	public String format(WxMsg msg) {
		String s = wxMsgConvert.convert2String(msg);
		return wxEncryptResolver.encode(s, WxContextUtil.getMsgInput());
	}

}
