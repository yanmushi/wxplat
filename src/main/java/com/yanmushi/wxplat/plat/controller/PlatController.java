/*
 * copyrity @ YanMushi 2015
 */
package com.yanmushi.wxplat.plat.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yanmushi.wxplat.plat.dao.PlatImageDao;
import com.yanmushi.wxplat.plat.model.PlatImage;

/**
 * @author yan.mushi
 * @since 
 */
@Controller
@RequestMapping("/plat/")
public class PlatController {

	@Resource PlatImageDao platImageDao;
	private int pagesize = 30;
	
	@RequestMapping("home.html")
	public String home(ModelMap map) {
		loadImages(0, map);
		return "plat/home";
	}
	
	/**
	 * @param offset
	 * @param map 
	 */
	private void loadImages(int offset, ModelMap map) {
		List<PlatImage> images = platImageDao.queryByMerchant(1, offset, pagesize);
		map.put("images", images);
		
	}

	@RequestMapping(value="next.html", produces="application/json")
	public String next(Integer offset, ModelMap map) {
		loadImages(offset, map);
		return "json";
	}
}
