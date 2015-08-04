/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.service.convert.dom4j;

import org.dom4j.Element;

import com.yanmushi.wxplat.wx.model.WxImageMsg;
import com.yanmushi.wxplat.wx.model.WxMsg;
import com.yanmushi.wxplat.wx.model.WxMsgType;

/**
 *
 * @author YinLei
 * @since 1.0
 */
public class WxImageMsgConvert extends AbstractWxMsgConvert {

	public WxImageMsgConvert(Class<? extends WxMsg> msgClass) {
		super(WxImageMsg.class);
	}

	@Override
	public String getRegistedFlag() {
		return WxMsgType.image.name();
	}

	@Override
	protected void bindCustom2Model(WxMsg wxMsg, Element root) {
		WxImageMsg msg = (WxImageMsg) wxMsg;
		msg.setPicUrl(root.elementText("PicUrl"));
		msg.setMediaId(root.elementText("MediaId"));
	}

	@Override
	protected void bindCustom2String(WxMsg wxMsg, Element root) {
		WxImageMsg msg = (WxImageMsg) wxMsg;
		root.addElement("Image")
			.addElement("MediaId").setText(msg.getMediaId());
	}

}
