/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.core;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author YinLei
 * @since 1.0
 */
public class WxStartUpListener implements InitializingBean, ApplicationContextAware {

	private WxContext wxContext;
	private ApplicationContext applicationContext;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		WxContextUtil.setContext(this.wxContext);
		Map<String, CustomInitializingBean> beans = applicationContext
				.getBeansOfType(CustomInitializingBean.class);

		for (Entry<String, CustomInitializingBean> bean : beans.entrySet()) {
			bean.getValue().afterCustomProperties();
		}
	}

	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		this.applicationContext = context;
	}

	public WxContext getWxContext() {
		return wxContext;
	}

	public void setWxContext(WxContext wxContext) {
		this.wxContext = wxContext;
	}

}
