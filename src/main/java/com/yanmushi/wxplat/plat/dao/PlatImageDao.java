/*
 * copyrity @ YanMushi 2015
 */
package com.yanmushi.wxplat.plat.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yanmushi.utils.JdbcUtils;
import com.yanmushi.wxplat.plat.model.PlatImage;

/**
 * @author yan.mushi
 * @since 
 */
@Repository
public class PlatImageDao {

	@Resource JdbcTemplate jdbcTemplate;
	private RowMapper<PlatImage> imageMapper = JdbcUtils.createBeanMapper(PlatImage.class);
	
	/**
	 * 通过商户信息，检索全部图书信息
	 * @param merchantId 商户ID
	 * @param offset 
	 * @param pageSize
	 * @return
	 */
	public List<PlatImage> queryByMerchant(Integer merchantId, int offset, int pageSize) {
		return jdbcTemplate.query("select * from plat_image where mid = ? limit ?, ?", 
				imageMapper, merchantId, offset, pageSize);
	}

	/**
	 * 通过图片id获取图片信息
	 * @param imageId
	 * @return
	 */
	public PlatImage getById(int imageId) {
		return jdbcTemplate.queryForObject("select * from plat_image where id = ?", 
				imageMapper, imageId);
	}
}
