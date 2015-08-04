/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.core.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yanmushi.wxplat.wx.model.WxAccessToken;

/**
 *
 * @author YinLei
 * @since 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class UrlWxAccessTokenLoaderTest {

	@Resource UrlWxAccessTokenLoader urlWxAccessTokenLoader;
	
	@Test
	public void test() {
		WxAccessToken token = urlWxAccessTokenLoader.load();
		System.out.println(token.getAccessToken());
	}

}
