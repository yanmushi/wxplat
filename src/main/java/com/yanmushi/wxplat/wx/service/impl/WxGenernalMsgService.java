/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.service.impl;

import com.yanmushi.wxplat.wx.model.WxMsg;
import com.yanmushi.wxplat.wx.model.WxMsgInput;
import com.yanmushi.wxplat.wx.service.WxMsgFormatter;
import com.yanmushi.wxplat.wx.service.WxRecivedMsgService;

/**
 * @author YinYan
 * @since 
 */
public class WxGenernalMsgService implements WxRecivedMsgService {
	
	private WxMsgFormatter wxMsgFormatter;
	
	@Override
	public String recived(WxMsgInput input) {
		WxMsg model = wxMsgFormatter.parse();
		
		return wxMsgFormatter.format(model);
	}

}
