/*
 * copyrity @ YanMushi 2015
 */
package com.yanmushi.wxplat.plat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yan.mushi
 * @since 
 */
@Controller
@RequestMapping("/plat/")
public class PlatController {

	@RequestMapping("home.html")
	public String home() {
		return "plat/home";
	}
}
