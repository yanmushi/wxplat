/*
 * copyrity @ YanMushi 2015
 */
package com.yanmushi.wxplat.plat.dao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yanmushi.wxplat.plat.model.PlatMerchant;

/**
 * @author yan.mushi
 * @since 
 */
@Repository
public class PlatMerchantDao {

	@Resource JdbcTemplate jdbcTemplate;
	
	public PlatMerchant findById(Integer id) {
		RowMapper<PlatMerchant> rm = new BeanPropertyRowMapper<>(PlatMerchant.class);
		return jdbcTemplate.queryForObject("select * from plat_merchant where id = ?", rm, id);
	}
}
