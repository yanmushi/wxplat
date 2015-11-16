/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author YinLei
 * @since 1.0
 */
@Controller
public class SystemController {

	@RequestMapping("login.html")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="login.html", produces="application/json")
	public String doLogin() {
		return "json";
	}
	
	@RequestMapping("logout.html")
	public String logout() {
		return "json";
	}
}
