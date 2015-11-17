/*
 * copyrity @ YanMushi 2015
 */
package com.yanmushi.wxplat.plat.dao;

import org.junit.Test;

import com.yanmushi.wxplat.SpringContextTest;
import com.yanmushi.wxplat.plat.model.PlatMerchant;

/**
 * @author yan.mushi
 * @since 
 */
public class PlatMerchantDaoTest {

	@Test
	public void test() {
		PlatMerchant obj = SpringContextTest.getBean(PlatMerchantDao.class).findById(1);
		System.out.println(obj.getMname());
	}

}
