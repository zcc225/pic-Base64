package com.yanmaikeji.ygjydemo;

import com.yanmaikeji.ygjydemo.util.Base64Util;

public class Base64Test {
	 public static void main(String[] args) {
		Base64Util base64Util = new Base64Util();
		String imageToBase64ByOnline = base64Util.ImageToBase64ByOnline("https://gss0.baidu.com/7Po3dSag_xI4khGko9WTAnF6hhy/zhidao/wh%3D800%2C450%3B/sign=1c7deef4d1c451daf6a304e386cd7e52/2934349b033b5bb5ce4256543ad3d539b700bc86.jpg");
		System.out.println(imageToBase64ByOnline);
	 }
}
