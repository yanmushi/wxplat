/*
 * copyrity @ YanMushi 2015
 */
package com.yanmushi.wxplat.plat.dao;

import org.junit.Test;

import com.yanmushi.wxplat.SpringContextTest;

/**
 * @author yan.mushi
 * @since 
 */
public class PlatImageDaoTest {

	@Test
	public void test() {
		PlatImageDao dao = SpringContextTest.getBean(PlatImageDao.class);
		System.out.println(dao.getById(1));
	}

}
