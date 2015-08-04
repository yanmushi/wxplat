/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.core;

import com.yanmushi.wxplat.wx.model.WxAccessToken;

/**
 *
 * @author YinLei
 * @since 1.0
 */
public interface WxAccessTokenLoader {

	WxAccessToken load();
}
