/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.exception;

/**
 *
 * @author YinLei
 * @since 1.0
 */
public class PlatExecption extends RuntimeException {

	private static final long serialVersionUID = -3483072038087324186L;

	/**
	 * 
	 */
	public PlatExecption() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public PlatExecption(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public PlatExecption(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public PlatExecption(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public PlatExecption(Throwable cause) {
		super(cause);
	}

}
