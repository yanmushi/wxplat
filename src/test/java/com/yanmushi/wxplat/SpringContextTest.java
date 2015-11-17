/*
 * copyrity @ YanMushi 2015
 */
package com.yanmushi.wxplat;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yan.mushi
 * @since 
 */
public class SpringContextTest {

	private static ApplicationContext context = 
			new ClassPathXmlApplicationContext(
					"classpath:/spring/*.xml");
	
	public static <T> T getBean(Class<T> clz) {
		return context.getBean(clz);
	}
	
	public static Object getBean(String name) {
		return context.getBean(name);
	}
	
	/**
	 * @return the context
	 */
	public static ApplicationContext getContext() {
		return context;
	}
	
	private SpringContextTest() {
	}
}
