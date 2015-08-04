/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author YinLei
 * @since 1.0
 */
public class JsonUtils {

	private static final ObjectMapper objectMapper = new ObjectMapper();
	
	static {
		// 将对象中不能识别的property忽略
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
	/**
	 * 将json字符串转换为Map对象
	 * @param json
	 * @return
	 * @version 1.1
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> parse2Map(String json) throws JsonParseException, JsonMappingException, IOException {
		return parse2Object(json, HashMap.class);
	}
	
	/**
	 * 将字符串转换为数据对象的数组信息
	 * @param json
	 * @param clz
	 * @return 如果json为NULL或空白字符串，返回null。
	 * @version 1.1
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public static <T> List<T> parse2List(String json, Class<T> clz) throws JsonParseException, JsonMappingException, IOException {
		if (StringUtils.isEmpty(json)) return null;
		JavaType javaType = createCollectionType(clz);
		List<T> val = null;
		val = objectMapper.readValue(json, javaType);
		return val;
	}
	
	private static <T> JavaType createCollectionType(Class<T> clz) {
		return objectMapper.getTypeFactory().constructParametrizedType(ArrayList.class, ArrayList.class, clz);
	}
	
	/**
	 * 将josn字符串转换为object
	 * @param json json字符串
	 * @param clz 目标对象类型
	 * @return 如果json为NULL或空白字符串，返回null。
	 * @version 1.1
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public static <T> T parse2Object(String json, Class<T> clz) throws JsonParseException, JsonMappingException, IOException {
		if (StringUtils.isEmpty(json)) return null;
		T val = null;
		val = objectMapper.readValue(json, clz);
		return val;
	}
	
	/**
	 * 将object转换为json字符串
	 * @param obj 转换对象
	 * @return 如果obj为NULL，返回null。
	 * @version 1.1
	 */
	public static String object2Json(Object obj) {
		if (obj == null) return null;
		String res = null;
		try {
			res = objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return res;
	}
	
}
