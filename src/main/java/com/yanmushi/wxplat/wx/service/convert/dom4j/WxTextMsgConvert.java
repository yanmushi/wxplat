/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.service.convert.dom4j;

import org.dom4j.Element;

import com.yanmushi.wxplat.wx.model.WxMsg;
import com.yanmushi.wxplat.wx.model.WxTextMsg;

/**
 * @author YinLei
 * @since 1.0
 */
public class WxTextMsgConvert extends AbstractWxMsgConvert {

	public WxTextMsgConvert() {
		super(WxTextMsg.class);
	}
	
	@Override
	protected void bindCustom2Model(WxMsg wxMsg, Element root) {
		WxTextMsg msg = (WxTextMsg) wxMsg;
		msg.setContent(root.elementText("Content"));
		
	}

	@Override
	protected void bindCustom2String(WxMsg wxMsg, Element root) {
		WxTextMsg msg = (WxTextMsg) wxMsg;
		root.addElement("Content").setText(msg.getContent());
	}

}
