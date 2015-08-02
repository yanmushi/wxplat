/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.service;

import com.yanmushi.wxplat.wx.model.WxMsg;
import com.yanmushi.wxplat.wx.model.WxMsgInput;

/**
 * @author YinLei
 * @since 
 */
public interface WxMsgReader {

	WxMsg read(WxMsgInput input);
}
