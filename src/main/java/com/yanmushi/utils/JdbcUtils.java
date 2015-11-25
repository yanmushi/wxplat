/*
 * copyrity @ YanMushi 2015
 */
package com.yanmushi.utils;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

/**
 * @author yan.mushi
 * @since 
 */
public class JdbcUtils {

	/**
	 * @param clz
	 * @return
	 */
	public static <T> RowMapper<T> createBeanMapper(Class<T> clz) {
		return new BeanPropertyRowMapper<>(clz);
	}
	
	private JdbcUtils() {}
}
