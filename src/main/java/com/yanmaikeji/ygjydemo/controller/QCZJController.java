package com.yanmaikeji.ygjydemo.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QCZJController {

	@RequestMapping("/qczjgetpic")
	@ResponseBody
	public HashMap<String, Object>   qczjgetpic(String url) throws IOException{
		String durl = URLDecoder.decode(url, "UTF-8");
		String newurl = durl.replace("https://m", "https://www");
		
		System.out.println(newurl);
		HashMap<String, Object> reuslt = new HashMap<String,Object>();
		if(url==null){
			reuslt.put("status", "0");
			reuslt.put("msg", "url不能为空");
		}
		System.out.println(url);
		String printUrlScreen2jpg = PhantomTools.printUrlScreen2jpg(newurl);
//			String imageToBase64ByLocal = Base64Util.ImageToBase64ByLocal(printUrlScreen2jpg);
//			if(imageToBase64ByLocal!=null){
//				reuslt.put("status", "0");
//				reuslt.put("picBase64str", imageToBase64ByLocal);
//			}
		return reuslt;
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
//		String encode = URLEncoder.encode("http://www.baidu.com", "UTF-8");
//		System.out.println(encode);
		
		String s = "https://m.che168.com/beijing/list/?pvareaid=104185";
		String replace = s.replace("https://m", "https://www");
		System.out.println(replace);
	}
}
