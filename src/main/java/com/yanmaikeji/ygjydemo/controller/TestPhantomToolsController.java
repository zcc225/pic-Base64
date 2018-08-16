package com.yanmaikeji.ygjydemo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yanmaikeji.ygjydemo.util.Base64Util;
@RestController
public class TestPhantomToolsController {
	private static String VIN_URL_FREE = "http://www.gzcc.gov.cn/data/QueryService/FileInfoemationVerify.aspx?ziguiEN={ziguiEN}&anhao={anhao}&xingming={xingming}&chanzhenghao={chanzhenghao}";
	private static String TBODY = "tbody";
	private static String TR = "tr";
	private static String TH = "th";
	private static String TD = "td";
	private static String P = "p";

	
	/**
	 * 
	    * @Title: getpic
	    * @Description: TODO(这里用一句话描述这个方法的作用)
	    * @param @param ziguiEN
	    * @param @param anhao
	    * @param @param xingming
	    * @param @param chanzhenghao
	    * @param @param model
	    * @param @return
	    * @param @throws IOException    参数
	    * @return HashMap<String,Object>    返回类型
	    * @throws
	 */
	@RequestMapping("/getpic")
	@ResponseBody
	public HashMap<String, Object> getpic(String ziguiEN,String anhao,String xingming,String chanzhenghao, Model model) throws IOException{
		
		HashMap<String, Object> reuslt = new HashMap<String,Object>();
		HashMap<String, String> tbodyMap = new HashMap<String,String>();
		LinkedList<String> linkedList = new LinkedList<String>();
		String url = VIN_URL_FREE.replace("{ziguiEN}", ziguiEN).replace("{anhao}", anhao).replace("{xingming}", xingming).replace("{chanzhenghao}", chanzhenghao);
		
		String printUrlScreen2jpg = PhantomTools.printUrlScreen2jpg(url);
		
		String imageToBase64ByLocal = Base64Util.ImageToBase64ByLocal(printUrlScreen2jpg);
		if(imageToBase64ByLocal!=null){
			reuslt.put("status", "0");
			reuslt.put("picBase64str", imageToBase64ByLocal);
			Document doc;
			doc = Jsoup.connect(url).get();
			//获取结果
			Element sresult = doc.getElementById("sresult");
			Elements resultTips = sresult.getElementsByClass("resultTips");
			for (Element element : resultTips) {
				Elements ps = element.getElementsByTag(P);
				if(ps.size()>2){
					Element element2 = ps.get(1);
					String text = element2.text();
					if(text.indexOf("不一致")!=-1){
						reuslt.put("result", "不一致");
					}else if(text.indexOf("一致")!=-1){
						reuslt.put("result", "一致");
					}else{
						reuslt.put("status", "1");
						reuslt.put("error", "数据错误");
					}
				}
			}
		}else{
			reuslt.put("status", "1");
		}
		return reuslt;
		
	}
}
