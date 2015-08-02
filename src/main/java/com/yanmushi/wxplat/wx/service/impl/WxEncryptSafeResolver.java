/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.service.impl;

import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import com.yanmushi.wxplat.wx.core.CustomInitializingBean;
import com.yanmushi.wxplat.wx.core.WxContextUtil;
import com.yanmushi.wxplat.wx.model.WxMsgInput;
import com.yanmushi.wxplat.wx.service.WxEncryptResolver;

/**
 * @author YinLei
 * @since 
 */
public class WxEncryptSafeResolver implements WxEncryptResolver,
		CustomInitializingBean {
	
	private WXBizMsgCrypt wxBizMsgCrypt = null;
	
	@Override
	public String decode(String msg, WxMsgInput input) {
		String mwmsg = null;
		try {
			mwmsg = wxBizMsgCrypt.decryptMsg(input.getSignature(), input.getTimestamp(),
					input.getNonce(), msg);
		} catch (AesException e) {
			// TODO 处理aes异常信息
			e.printStackTrace();
		}
		return mwmsg;
	}

	@Override
	public String encode(String msg, WxMsgInput input) {
		String res = null;
		try {
			res = wxBizMsgCrypt.encryptMsg(msg, input.getTimestamp(),
					input.getNonce());
		} catch (AesException e) {
			// TODO 处理aes异常信息
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public void afterCustomProperties() throws Exception {
		wxBizMsgCrypt = new WXBizMsgCrypt(WxContextUtil.getToken(),
				WxContextUtil.getAesKey(), WxContextUtil.getAppId());
	}

}
