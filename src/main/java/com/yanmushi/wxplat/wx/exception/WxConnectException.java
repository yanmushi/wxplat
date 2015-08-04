/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx.exception;

import com.yanmushi.wxplat.exception.PlatExecption;

/**
 *
 * @author YinLei
 * @since 1.0
 */
public class WxConnectException extends PlatExecption {

	private static final long serialVersionUID = -312176391356031806L;

	/**
	 * 
	 */
	public WxConnectException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public WxConnectException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public WxConnectException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public WxConnectException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public WxConnectException(Throwable cause) {
		super(cause);
	}

}
