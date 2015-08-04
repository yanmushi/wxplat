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
public class UnsupportConvertException extends PlatExecption {

	private static final long serialVersionUID = -4340726390361635643L;

	/**
	 * 
	 */
	public UnsupportConvertException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public UnsupportConvertException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public UnsupportConvertException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public UnsupportConvertException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public UnsupportConvertException(Throwable cause) {
		super(cause);
	}

}
