package com.yanmaikeji.ygjydemo;

import com.yanmaikeji.ygjydemo.util.Base64Util;

public class Base64Test {
	 public static void main(String[] args) {
		Base64Util base64Util = new Base64Util();
		String imageToBase64ByOnline = base64Util.ImageToBase64ByOnline("https://www.daixinlian.com/images/banner_1.png");
		System.out.println(imageToBase64ByOnline);
	 }
}
