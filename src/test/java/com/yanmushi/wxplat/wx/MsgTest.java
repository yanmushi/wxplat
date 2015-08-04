/*
 * Copyright (c) 2014-2015 YanMushi 
 * All rights reserved.
 */
package com.yanmushi.wxplat.wx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;

/**
 *
 * @author YinLei
 * @since 1.0
 */
public class MsgTest {

	@Test
	public void test() throws IOException {
		URL u = new URL("http://localhost:9092/wxplat/wx/accept.html");
		HttpURLConnection con = (HttpURLConnection) u.openConnection();
		
		con.setRequestMethod("POST");
//		con.setDoInput(true);
		con.setDoOutput(true);
		OutputStream out = con.getOutputStream();
		
		String msg = "<xml><ToUserName><![CDATA[gh_e844439126f0]]></ToUserName><Encrypt><![CDATA[LZuYSS/lqWroYL7nRM2Zvtvg1w5fpHgKEqx+pzcQjEJyBJDWdB0RL0PKBwrzMxCct+K8UYIXN/fi7JDUSv2ujEQTVsjspbGeltexPnUjuD/ghuwXbGHgT37opmuA7lUkF1H6LfAeqdgGQakiYU3h51oXmw53X0nr9JyDg4AR0iD2FBVmmiqFXyWC3f8zlEurHYsR/owCjJ4otFX6lDPSjb1CaikoZbg43ckandW4aOkYdc0STATlLgiZjY7ZmyoCkzgKxqKXliCopqLv6axbUJbzZxLPXXFM000GOl1zi/JJbxyBw/Ml1KYgi81Cq645wFhGXxSvdlWtMDU3DkRs40TqWeGkk3YYfqqnoiiph2D8CcmfA+JNc4UNGInOBrm4niVoKm+dCWbh/AlJVBmlDG7/Og5ISOTRZZYU+01huBk=]]></Encrypt>xml>";
		msg = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[fromUser]]></FromUserName><CreateTime>1348831860</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[this is a test]]></Content><MsgId>1234567890123456</MsgId></xml>";
		
		out.write(msg.getBytes());
		
		print(con.getInputStream());
	}
	
	@Test
	public void testBaidu() throws IOException {
		URL url = new URL("http://www.baidu.com");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		System.out.println(con.getDoInput());
		
		print(con.getInputStream());
	}

	/**
	 * @param inputStream
	 * @throws IOException 
	 */
	private void print(InputStream in) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String s = null;
		while ((s = br.readLine()) != null) {
			System.out.println(s);
		}		
	}
}
