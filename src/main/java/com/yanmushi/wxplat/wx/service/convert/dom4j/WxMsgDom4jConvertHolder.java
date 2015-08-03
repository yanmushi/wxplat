/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.service.convert.dom4j;

import org.dom4j.Element;

/**
 * @author YinLei
 * @since 1.0
 */
public class WxMsgDom4jConvertHolder {

	private static ThreadLocal<Element> threadLocal = 
			new ThreadLocal<Element>();
	
	public static Element get() {
		return threadLocal.get();
	}
	
	public static void set(Element root) {
		threadLocal.set(root);
	}
}
