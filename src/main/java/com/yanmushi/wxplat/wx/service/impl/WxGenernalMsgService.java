/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.service.impl;

import java.io.StringReader;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import com.yanmushi.wxplat.wx.core.WxContextUtil;
import com.yanmushi.wxplat.wx.model.WxMsgInput;
import com.yanmushi.wxplat.wx.model.WxTextMsg;
import com.yanmushi.wxplat.wx.service.WxEncryptService;
import com.yanmushi.wxplat.wx.service.WxRecivedMsgService;

/**
 * @author YinYan
 * @since 
 */
public class WxGenernalMsgService implements WxRecivedMsgService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(WxGenernalMsgService.class);
	
	private WxEncryptService wxEncryptService;
	
	@Override
	public String recived(WxMsgInput input) {
		String outStr = "";
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(input.getIn());
			LOGGER.debug("accept encrypt msg: {}" , doc.asXML());

			
			WXBizMsgCrypt pc = new WXBizMsgCrypt(WxContextUtil.getToken(), WxContextUtil.getAesKey(), WxContextUtil.getAppId());

			String mwmsg = pc.decryptMsg(input.getSignature(), input.getTimestamp(), input.getNonce(), doc.asXML());

			doc = reader.read(new StringReader(mwmsg));
			LOGGER.debug("real decrypt msg: {}" , doc.asXML());
			
			Element root = doc.getRootElement();
			
			String msgType = root.elementText("MsgType");
			
			
			if ("text".equals(msgType)) {
				WxTextMsg msg = new WxTextMsg();
				msg.setContent(root.elementText("Content"));
				msg.setCreateTime(root.elementText("CreateTime"));
				msg.setFromUserName(root.elementText("FromUserName"));
				msg.setMsgId(root.elementText("MsgId"));
				msg.setToUserName(root.elementText("ToUserName"));

				root.element("FromUserName").setText(msg.getToUserName());
				root.element("ToUserName").setText(msg.getFromUserName());
				root.element("Content").setText("welcome, [" + msg.getFromUserName() + "], " + msg.getContent());
				root.element("CreateTime").setText(System.currentTimeMillis()+"");
				outStr = root.asXML();
				
				LOGGER.debug("use msg: {}", outStr);
				
				outStr = pc.encryptMsg(outStr, input.getTimestamp(), input.getNonce());
				
				LOGGER.debug("send msg: {}", outStr);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (AesException e) {
			e.printStackTrace();
		}
		
		return outStr;
	}

}
