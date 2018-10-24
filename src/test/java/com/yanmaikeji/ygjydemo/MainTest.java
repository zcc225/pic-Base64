package com.yanmaikeji.ygjydemo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;

import org.apache.commons.codec.digest.DigestUtils;
import org.json.JSONArray;

import com.google.gson.Gson;

import net.minidev.json.JSONUtil;

public class MainTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
//		MD5time();
		
//		URLM(); 
//		http%3A%2F%2Fzhixing.court.gov.cn%2Fsearch%2Fnewsearch%3FsearchCourtName%3D%25E5%2585%25A8%25E5%259B%25BD%25E6%25B3%2595%25E9%2599%25A2%25EF%25BC%2588%25E5%258C%2585%25E5%2590%25AB%25E5%259C%25B0%25E6%2596%25B9%25E5%2590%2584%25E7%25BA%25A7%25E6%25B3%2595%25E9%2599%25A2%25EF%25BC%2589%26selectCourtId%3D1%26selectCourtArrange%3D1%26pname%3D%25E8%25A2%2581%25E6%259C%25AC%25E5%258D%25B0%26cardNum%3D422727197303063878%26j_captcha%3Deuza%26captchaId%3D55804cc44e5d4a4fbdfea24dd81154a9
//		localhost:8888/getresult?seachUrl=http%3A%2F%2Fzhixing.court.gov.cn%2Fsearch%2Fnewsearch%3FsearchCourtName%3D%25E5%2585%25A8%25E5%259B%25BD%25E6%25B3%2595%25E9%2599%25A2%25EF%25BC%2588%25E5%258C%2585%25E5%2590%25AB%25E5%259C%25B0%25E6%2596%25B9%25E5%2590%2584%25E7%25BA%25A7%25E6%25B3%2595%25E9%2599%25A2%25EF%25BC%2589%26selectCourtId%3D1%26selectCourtArrange%3D1%26pname%3D%25E8%25A2%2581%25E6%259C%25AC%25E5%258D%25B0%26cardNum%3D422727197303063878%26j_captcha%3Deuza%26captchaId%3D55804cc44e5d4a4fbdfea24dd81154a9
//		String encode = URLEncoder.encode("http://zhixing.court.gov.cn/search/newsearch?searchCourtName=%E5%85%A8%E5%9B%BD%E6%B3%95%E9%99%A2%EF%BC%88%E5%8C%85%E5%90%AB%E5%9C%B0%E6%96%B9%E5%90%84%E7%BA%A7%E6%B3%95%E9%99%A2%EF%BC%89&selectCourtId=1&selectCourtArrange=1&pname=%E8%A2%81%E6%9C%AC%E5%8D%B0&cardNum=422727197303063878&j_captcha=euza&captchaId=55804cc44e5d4a4fbdfea24dd81154a9","UTF-8");
//		System.out.println(encode);
		
		test();
	}

	private static void URLM() {
		String seachUrl="http://zhixing.court.gov.cn/search/newsearch?searchCourtName=%E5%85%A8%E5%9B%BD%E6%B3%95%E9%99%A2%EF%BC%88%E5%8C%85%E5%90%AB%E5%9C%B0%E6%96%B9%E5%90%84%E7%BA%A7%E6%B3%95%E9%99%A2%EF%BC%89&selectCourtId=1&selectCourtArrange=1&pname=%E8%A2%81%E6%9C%AC%E5%8D%B0&cardNum=422727197303063878&j_captcha=euza&captchaId=55804cc44e5d4a4fbdfea24dd81154a9";
		
		try {
			// 将application/x-www-from-urlencoded字符串转换成普通字符串  
			String keyWord = URLDecoder.decode("%C4%E3%BA%C3", "GBK");  
			System.out.println(keyWord);  //输出你好
			String aaa = URLDecoder.decode("searchCourtName=%E5%85%A8%E5%9B%BD%E6%B3%95%E9%99%A2%EF%BC%88%E5%8C%85%E5%90%AB%E5%9C%B0%E6%96%B9%E5%90%84%E7%BA%A7%E6%B3%95%E9%99%A2%EF%BC%89&selectCourtId=1&selectCourtArrange=1&pname=%E8%A2%81%E6%9C%AC%E5%8D%B0&cardNum=422727197303063878&j_captcha=euza&captchaId=55804cc44e5d4a4fbdfea24dd81154a9", "UTF-8");  
			System.out.println(aaa);  //输出你好
			// 将普通字符创转换成application/x-www-from-urlencoded字符串  
			String urlString = URLEncoder.encode("你好", "GBK");  //输出%C4%E3%BA%C3
			System.out.println(urlString);
			String urlString2 = URLEncoder.encode("searchCourtName=全国法院（包含地方各级法院）&selectCourtId=1&selectCourtArrange=1&pname=袁本印&cardNum=422727197303063878&j_captcha=euza&captchaId=55804cc44e5d4a4fbdfea24dd81154a9", "UTF-8");  //输出%C4%E3%BA%C3
			System.out.println(urlString2);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void MD5time() {
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println(currentTimeMillis);
//		byte[] md5 = DigestUtils.md5("c351uffj0xgztgyrsvgq"+currentTimeMillis+"天河公园");
		String md5Hex = DigestUtils.md5Hex("c351uffj0xgztgyrsvgq"+currentTimeMillis+"天河公园");
		System.out.println(md5Hex);
		
		String md5Hex2 = DigestUtils.md5Hex("c351uffj0xgztgyrsvgq"+currentTimeMillis+"1808135200019573");
		System.out.println(md5Hex2);
		
		System.out.println("aaaaa\n aaaaa");
	}
	
	
	
	public static void test(){
//		{"name":"AC Schnitzer","aid":"117","brand":"AC Schnitzer"}
//		{"id":"117" ,"name":"AC Schnitzer" ,"brand":"AC Schnitzer"}
//		<dd data-value=    {"id":
//		data-text=  ,"name":  
//		 data-target="brand">  ,"brand":"
//		</dd> "}
		HashMap<String ,String > hashMap = new HashMap<>();
		hashMap.put("aid", "117");
		hashMap.put("brand", "AC Schnitzer");
		hashMap.put("name", "AC Schnitzer");
		
		String json = new Gson().toJson(hashMap);
		System.out.println(json);
		
		
	}
}
