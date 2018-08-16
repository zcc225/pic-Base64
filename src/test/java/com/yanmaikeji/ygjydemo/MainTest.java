package com.yanmaikeji.ygjydemo;

import org.apache.commons.codec.digest.DigestUtils;

public class MainTest {

	public static void main(String[] args) {
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println(currentTimeMillis);
//		byte[] md5 = DigestUtils.md5("c351uffj0xgztgyrsvgq"+currentTimeMillis+"天河公园");
		String md5Hex = DigestUtils.md5Hex("c351uffj0xgztgyrsvgq"+currentTimeMillis+"天河公园");
		System.out.println(md5Hex);
		
		String md5Hex2 = DigestUtils.md5Hex("c351uffj0xgztgyrsvgq"+currentTimeMillis+"1808135200019573");
		System.out.println(md5Hex2);
		
		System.out.println("aaaaa\n aaaaa");
		
		
	}
}
