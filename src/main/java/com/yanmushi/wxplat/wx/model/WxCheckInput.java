/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.model;

/**
 * @author YinYan
 * @since 
 */
public class WxCheckInput {
	private String signature;
	private String timestamp;
	private String nonce;
	private String echostr;
	
	/**
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param echostr
	 */
	public WxCheckInput(String signature, String timestamp, String nonce,
			String echostr) {
		super();
		this.signature = signature;
		this.timestamp = timestamp;
		this.nonce = nonce;
		this.echostr = echostr;
	}
	/**
	 * @return the signature
	 */
	public String getSignature() {
		return signature;
	}
	/**
	 * @param signature the signature to set
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}
	/**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * @return the nonce
	 */
	public String getNonce() {
		return nonce;
	}
	/**
	 * @param nonce the nonce to set
	 */
	public void setNonce(String nonce) {
		this.nonce = nonce;
	}
	/**
	 * @return the echostr
	 */
	public String getEchostr() {
		return echostr;
	}
	/**
	 * @param echostr the echostr to set
	 */
	public void setEchostr(String echostr) {
		this.echostr = echostr;
	}
}
