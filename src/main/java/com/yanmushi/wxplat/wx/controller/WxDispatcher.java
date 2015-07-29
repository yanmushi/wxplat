/**
 * Create time 2015-7-28 下午9:28:39
 */
package com.yanmushi.wxplat.wx.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping("index.html")
	public String index(ModelMap map) {
		Map<String, String> datas = new HashMap<String, String>();
		datas.put("text", "123");
		map.put("xml", datas);
		return "xml";
	}
}
