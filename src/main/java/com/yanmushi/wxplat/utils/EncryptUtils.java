/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang3.StringUtils;

import com.yanmushi.wxplat.exception.PlatExecption;

/**
 * 主要实现数据加密算法
 * <br/>
 * <pre>
 * String strSrc = "可以加密汉字.Oh,and english";
 * System.out.println("Source String:" + strSrc);
 * System.out.println("Encrypted String:");
 * System.out.println("Use Def:" + EncryptUtils.encrypt(strSrc, null));
 * System.out.println("Use MD5:" + EncryptUtils.encrypt(strSrc, EncryptType.MD5));
 * System.out.println("Use SHA:" + EncryptUtils.encrypt(strSrc, EncryptType.SHA1));
 * System.out.println("Use SHA-256:" + EncryptUtils.encrypt(strSrc, EncryptType.SHA256));
 * </pre>
 * @author YinLei
 * @since 1.0
 */
public class EncryptUtils {

	/**
	 * the algorithm name will be used.
	 * we must use the code in the type.
	 * <pre>
	 *   MD5.getCode();
	 * </pre>
	 * @author YinLei
	 * @since 1.0
	 */
	public static enum EncryptType {
		MD5("MD5"), SHA1("SHA-1"), SHA256("SHA-256");
		private String code;
		private EncryptType(String code) {
			this.code = code;
		}
		/**
		 * @return the real name used to encrypt
		 */
		public String getCode() {
			return code;
		}
	}

	/**
	 * @param strSrc 源字符串信息
	 * @param encryptType 加密类型
	 * @throws PlatExecption 如果输入的字符串为NULL或空
	 * @return
	 */
	public static String encrypt(String strSrc, EncryptType encryptType) {
		// parameter strSrc is a string will be encrypted,
		// parameter encName is the algorithm name will be used.
		// encName dafault to "MD5"
		
		if (StringUtils.isEmpty(strSrc)) 
			throw new PlatExecption("you must enter a valid string!");
		
		MessageDigest md = null;
		String strDes = null;

		byte[] bt = strSrc.getBytes();
		try {
			if (encryptType == null) {
				encryptType = EncryptType.MD5;
			}
			md = MessageDigest.getInstance(encryptType.getCode());
			md.update(bt);
			strDes = bytes2Hex(md.digest()); // to HexString
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Invalid algorithm.");
			return null;
		}
		return strDes;
	}

	private static String bytes2Hex(byte[] bts) {
		String des = "";
		String tmp = null;
		for (int i = 0; i < bts.length; i++) {
			tmp = (Integer.toHexString(bts[i] & 0xFF));
			if (tmp.length() == 1) {
				des += "0";
			}
			des += tmp;
		}
		return des;
	}
}
