/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.service.convert.dom4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.yanmushi.wxplat.exception.PlatExecption;
import com.yanmushi.wxplat.wx.model.WxMsg;
import com.yanmushi.wxplat.wx.model.WxMsgInput;
import com.yanmushi.wxplat.wx.service.WxMsgConvert;

/**
 * @author YinLei
 * @since 1.0
 */
public abstract class AbstractWxMsgConvert implements WxMsgConvert {

	private static final Map<String, Method> toModelMethods;
	private static final Map<String, Method> toStringMethods;

	static {
		 toModelMethods = new HashMap<>();
		 toStringMethods = new HashMap<>();
		 registe("toUserName");
		 registe("fromUserName");
		 registe("createTime");
		 registeSetter(handleName("msgId"));
		 registeGetter(handleName("msgType"));
	}
	
	private static String handleName(String field) {
		StringBuffer sb = new StringBuffer(field);
		sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
		return sb.toString();
	}
	
	private static void registe(String field) {
		String name = handleName(field);
		registeSetter(name);
		registeGetter(name);
	}
	
	private static void registeSetter(String name) {
		try {
			Method setter = WxMsg.class.getMethod("set" + name, String.class);
			toModelMethods.put(name, setter);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}
	
	private static void registeGetter(String name) {
		try {
			Method getter = WxMsg.class.getMethod("get" + name, String.class);
			toStringMethods.put(name, getter);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}
	
	private Class<? extends WxMsg> msgClass;
	
	public AbstractWxMsgConvert(Class<? extends WxMsg> msgClass) {
		this.msgClass = msgClass;
	}
	
	@Override
	public WxMsg convert2Model(String msg, WxMsgInput input) {
		Element root = WxMsgDom4jConvertHolder.get();
		WxMsg wxMsg = null;
		try {
			wxMsg = msgClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new PlatExecption(e);
		}
		
		for (Entry<String, Method> entry : toModelMethods.entrySet()) {
			String key = entry.getKey();
			String text = root.element(key).getText();
			invoke(entry.getValue(), wxMsg, text);
		}
		
		bindCustom2Model(wxMsg, root);
		
		return wxMsg;
	}

	@Override
	public String convert2String(WxMsg wxMsg) {
		Document doc = DocumentHelper.createDocument();
		Element root = doc.addElement("xml");
		
		for (Entry<String, Method> entry : toStringMethods.entrySet()) {
			String key = entry.getKey();
			String text = loadText(entry.getValue(), wxMsg);
			root.addElement(key).setText(text);
		}
		
		bindCustom2String(wxMsg, root);
		
		return doc.asXML();
	}

	/**
	 * @param value
	 * @param wxMsg
	 * @param key
	 * @return
	 */
	private String loadText(Method value, WxMsg wxMsg) {
		try {
			return (String) value.invoke(wxMsg);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new PlatExecption(e);
		}
	}

	// 绑定抽象类值
	private void invoke(Method value, WxMsg textMsg, String text) {
		try {
			value.invoke(textMsg, text);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}		
	}

	/**
	 * 绑定个性化的数据信息到业务对象
	 * @param wxMsg
	 * @param root
	 */
	protected abstract void bindCustom2Model(WxMsg wxMsg, Element root);

	/**
	 * 绑定个性化数据信息转换为字符串的处理
	 * @param wxMsg
	 * @param root
	 */
	protected abstract void bindCustom2String(WxMsg wxMsg, Element root);

	/**
	 * @return the msgClass
	 */
	protected Class<? extends WxMsg> getMsgClass() {
		return msgClass;
	}

	/**
	 * @param msgClass the msgClass to set
	 */
	protected void setMsgClass(Class<? extends WxMsg> msgClass) {
		this.msgClass = msgClass;
	}

}
