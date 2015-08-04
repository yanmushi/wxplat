/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yanmushi.wxplat.wx.model.WxCheckInput;
import com.yanmushi.wxplat.wx.model.WxMsgInput;
import com.yanmushi.wxplat.wx.service.WxCheckMsgService;
import com.yanmushi.wxplat.wx.service.WxRecivedMsgService;

/**
 * <p>Title: WxDispatcher</p>
 * <p>Description:web分发 </p>
 *
 * @author YanMushi
 * @version 1.0
 */
@Controller
@RequestMapping("/wx")
public class WxDispatcher {
	
	@Resource WxRecivedMsgService wxRecivedMsgService;
	@Resource WxCheckMsgService wxCheckMsgService;
	
	@RequestMapping("index.html")
	public String index(ModelMap map) {
		return "json";
	}
	
	@RequestMapping(value="accept.html", method=RequestMethod.GET)
	public void access(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");

		WxCheckInput model = new WxCheckInput(signature, timestamp, nonce,
				echostr);

		String out = wxCheckMsgService.check(model);

		write(response, out);
	}

	private void write(HttpServletResponse response, String out)
			throws IOException {
		response.getWriter().write(out);
		response.getWriter().flush();
	}

	@RequestMapping(value="accept.html", method=RequestMethod.POST)
	public void accept(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		InputStream in = request.getInputStream();
		if (in == null)
			return;

		String signature = request.getParameter("msg_signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		WxMsgInput input = new WxMsgInput(in, signature, timestamp, nonce);

		String out = wxRecivedMsgService.recived(input);

		write(response, out);
	}

}
