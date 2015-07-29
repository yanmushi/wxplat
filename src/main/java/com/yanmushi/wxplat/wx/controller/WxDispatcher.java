/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import com.yanmushi.wxplat.utils.EncryptUtils;
import com.yanmushi.wxplat.utils.EncryptUtils.EncryptType;
import com.yanmushi.wxplat.wx.core.WxContext;
import com.yanmushi.wxplat.wx.model.WxTextMsg;

/**
 * <p>Title: WxDispatcher</p>
 * <p>Description: </p>
 *
 * @author YanMushi
 * @version 1.0
 */
@Controller
@RequestMapping("/wx")
public class WxDispatcher {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WxDispatcher.class);
	
	@Resource WxContext wxContext;
	
	@RequestMapping("index.html")
	public String index(ModelMap map) {
		return "json";
	}
	
	@RequestMapping(value="accept.html", method=RequestMethod.GET)
	public void access(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		
		String tmpst = handleSignature(timestamp, nonce);
		String outStr = "";
		if (tmpst.equals(signature)) {
			outStr = echostr;
		}

		LOGGER.debug("params: signature:{}, timestamp:{}, nonce:{}, "
				+ "echostr:{}, tmpst:{}, outStr:{}, token:{}", signature, timestamp,
				nonce, echostr, tmpst, outStr, wxContext.getToken());
		
		response.getWriter().write(outStr);
		response.getWriter().flush();
	}

	@RequestMapping(value="accept.html", method=RequestMethod.POST)
	public void accept(HttpServletRequest request, HttpServletResponse response) throws IOException {
		InputStream in = request.getInputStream();
		if (in == null) return;
		
		String signature = request.getParameter("msg_signature");
		String timestamp = request.getParameter("timestamp");	
		String nonce = request.getParameter("nonce");	
		String outStr = "";
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(in);
			LOGGER.debug("accept encrypt msg: {}" , doc.asXML());

			LOGGER.debug("params: signature:{}, timestamp:{}, nonce:{}, "
					+ "outStr:{}, token:{}, aesKey:{}, appId:{}", signature, timestamp,
					nonce, outStr, wxContext.getToken(), wxContext.getAesKey(), wxContext.getAppId());
			
			WXBizMsgCrypt pc = new WXBizMsgCrypt(wxContext.getToken(), wxContext.getAesKey(), wxContext.getAppId());

			String mwmsg = pc.decryptMsg(signature, timestamp, nonce, doc.asXML());

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
				
				outStr = pc.encryptMsg(outStr, timestamp, nonce);
				
				LOGGER.debug("send msg: {}", outStr);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (AesException e) {
			e.printStackTrace();
		}
		response.getWriter().write(outStr);
		response.getWriter().flush();

		LOGGER.debug("last msg: {}", outStr);
	}

	/**
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	private String handleSignature(String timestamp, String nonce) {
		List<String> list = new ArrayList<String>(3);
		list.add(wxContext.getToken());
		list.add(timestamp);
		list.add(nonce);
		Collections.sort(list);	
		String result = config(list);
		result = EncryptUtils.encrypt(result, EncryptType.SHA1);
		return result;
	}

	/**
	 * @param list
	 * @return
	 */
	private String config(List<String> list) {
		StringBuffer sb = new StringBuffer();
		for (String s : list) {
			sb.append(s);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		WxDispatcher w = new WxDispatcher();
		List<String> list = new ArrayList<String>(3);
		list.add("1438147955");
		list.add("137546831");
		list.add("myWxPlatToken");
		Collections.sort(list);
		System.out.println(list);
		
		System.out.println(EncryptUtils.encrypt(w.config(list), EncryptType.SHA1));
		
	}
}
