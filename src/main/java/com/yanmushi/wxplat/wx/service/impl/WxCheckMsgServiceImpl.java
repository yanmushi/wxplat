/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.yanmushi.wxplat.utils.EncryptUtils;
import com.yanmushi.wxplat.utils.EncryptUtils.EncryptType;
import com.yanmushi.wxplat.wx.core.WxContextUtil;
import com.yanmushi.wxplat.wx.model.WxCheckInput;
import com.yanmushi.wxplat.wx.service.WxCheckMsgService;

/**
 * 主要实现了【验证消息 真实性】服务
 * @author YinLei
 * @since 
 */
public class WxCheckMsgServiceImpl implements WxCheckMsgService {

	@Override
	public String check(WxCheckInput model) {
		String tmp = handleData2Signature(model);
		String res = "";
		if (tmp.equals(model.getSignature())) {
			res = model.getEchostr();
		}
		return res;
	}

	/**
	 * @param model
	 * @return
	 */
	private String handleData2Signature(WxCheckInput model) {
		List<String> list = new ArrayList<String>(3);
		list.add(WxContextUtil.getToken());
		list.add(model.getTimestamp());
		list.add(model.getNonce());
		Collections.sort(list);	
		String result = appendListToString(list);
		result = EncryptUtils.encrypt(result, EncryptType.SHA1);
		return result;
	}

	/**
	 * @param list
	 * @return
	 */
	private String appendListToString(List<String> list) {
		StringBuffer res = new StringBuffer();
		for (String s : list) {
			res.append(s);
		}
		return res.toString();
	}

}
