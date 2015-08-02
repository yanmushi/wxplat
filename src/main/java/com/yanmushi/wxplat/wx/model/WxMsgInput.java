/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.model;

import java.io.InputStream;

/**
 * @author YinLei
 * @since 
 */
public class WxMsgInput {

	private InputStream in;
	private String signature;
	private String timestamp;
	private String nonce;
	
	/**
	 * @param in
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 */
	public WxMsgInput(InputStream in, String signature, String timestamp,
			String nonce) {
		super();
		this.in = in;
		this.signature = signature;
		this.timestamp = timestamp;
		this.nonce = nonce;
	}
	/**
	 * @return the in
	 */
	public InputStream getIn() {
		return in;
	}
	/**
	 * @param in the in to set
	 */
	public void setIn(InputStream in) {
		this.in = in;
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

}
