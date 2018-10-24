package com.yanmaikeji.ygjydemo.controller;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yanmaikeji.ygjydemo.util.Base64Util;

@Controller
public class TestController {
	
	
	
	@RequestMapping("/index")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "aaaa");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }
	
	@SuppressWarnings("deprecation")
	@RequestMapping("/testhtml")
	public String   testHtml(String pname,String cardNum,String captcha ,String captchaId,ModelMap map) throws UnsupportedEncodingException{
		String enpname = null;
		String encardNum = null;
		try {
			enpname = URLEncoder.encode(pname,"UTF-8");
			encardNum = URLEncoder.encode(cardNum,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
//		//随机获取一个验证码key
//		String capchaId = UUIDUtil.getUUID();
//		System.out.println("验证码key"+capchaId);
//		//组装 验证码获取url
//		String getcapchaurl = "http://zhixing.court.gov.cn/search/captcha.do?captchaId="+capchaId+"&random=0.4185783191569461";
//		System.out.println("验证码图片URL"+getcapchaurl);
//		// 获取验证码图片base64
//		String imageToBase64ByOnline = Base64Util.ImageToBase64ByOnline(getcapchaurl);
//		System.out.println("验证码图片base64"+imageToBase64ByOnline);
		//解析验证码
		String seachUrl="http://zhixing.court.gov.cn/search/newsearch?searchCourtName=%E5%85%A8%E5%9B%BD%E6%B3%95%E9%99%A2%EF%BC%88%E5%8C%85%E5%90%AB%E5%9C%B0%E6%96%B9%E5%90%84%E7%BA%A7%E6%B3%95%E9%99%A2%EF%BC%89&selectCourtId=1&selectCourtArrange=1&pname="+enpname+"&cardNum="+encardNum+"&j_captcha="+captcha+"&captchaId="+captchaId;
//		String seachUrl="http://www.baidu.com";
		String encode = URLEncoder.encode(seachUrl,"UTF-8");
		System.out.println("加密的链接"+encode);
		System.out.println(seachUrl);
		map.addAttribute("pnamespan", pname);
		map.addAttribute("cardNumspan", cardNum);
		map.addAttribute("url", "http://192.168.10.80:8888/getresult?seachUrl="+encode);
		map.addAttribute("captcha", captcha);
		return "fayuannew";
	}
	
	
	@RequestMapping("/submit")
	@ResponseBody
	public HashMap<String, Object>   submit(String pname,String cardNum,String captcha ,String captchaId) throws IOException{
		HashMap<String, Object> reuslt = new HashMap<String,Object>();
		if(pname==null || captcha==null || cardNum==null || captchaId ==null){
			reuslt.put("status", "9001");
			reuslt.put("Msg", "pname captcha  cardNum captchaId  都不能为空");
			return reuslt;
		}
		String enpname = URLEncoder.encode(pname,"UTF-8");
		String encardNum = URLEncoder.encode(cardNum,"UTF-8");
		 String url = "http://192.168.10.80:8888/testhtml?pname="+enpname+"&cardNum="+encardNum+"&captcha="+captcha+"&captchaId="+captchaId;;//以百度网站首页为例
	     PhantomTools.printUrlScreen2jpg(url);
	     
		 String printUrlScreen2jpg = PhantomTools.printUrlScreen2jpg(url);
			String imageToBase64ByLocal = Base64Util.ImageToBase64ByLocal(printUrlScreen2jpg);
			if(imageToBase64ByLocal!=null){
				reuslt.put("status", "0");
				reuslt.put("picBase64str", imageToBase64ByLocal);
			}
		return reuslt;
//		return "redirect:/testhtml?pname="+pname+"&cardNum="+cardNum+"&captcha="+captcha+"&captchaId="+captchaId;
	}
	
	
	@RequestMapping("/getresult")
	public String   getresult(String seachUrl) throws IOException{
		
//		String decode = URLDecoder.decode(seachUrl,"UTF-8");
//		ByteArrayOutputStream data = new ByteArrayOutputStream();
//			// 创建URL
//			URL url = new URL(decode);
//			byte[] by = new byte[1024];
//			// 创建链接
//			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//			conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
//			conn.setRequestMethod("GET");
////			conn.setConnectTimeout(5000);
//			String responseMessage = conn.getResponseMessage();
//			System.out.println(responseMessage);
//			return null;
		return "redirect:"+seachUrl;
	}

	@RequestMapping("/getYjjyPrintscreen")
	public String test(HttpServletResponse resp) throws MalformedURLException, IOException, URISyntaxException, AWTException{
//		// 此方法仅适用于JdK1.6及以上版本
//				Desktop.getDesktop().browse(
//						new URL("http://www.gzcc.gov.cn/data/QueryService/FileInfoemationVerify.aspx?ziguiEN=DC&anhao=1111&xingming=1111&chanzhenghao=11111").toURI());
//				Robot robot = new Robot();
//				robot.delay(10000);
//				Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
//				int width = (int) d.getWidth();
//				int height = (int) d.getHeight();
//				// 最大化浏览器
//				robot.keyRelease(KeyEvent.VK_F11);
//				robot.delay(2000);
//				robot.mouseWheel(5);
//				robot.mouseMove(1060, 834);
//				robot.mousePress(KeyEvent.BUTTON1_MASK);
//				robot.mouseRelease(KeyEvent.BUTTON1_MASK);
//				robot.delay(2000);
//				Image image = robot.createScreenCapture(new Rectangle(0, 0, width,
//						height));
//				BufferedImage bi = new BufferedImage(width, height,
//						BufferedImage.TYPE_INT_RGB);
//				Graphics g = bi.createGraphics();
//				g.drawImage(image, 0, 0, width, height, null);
//				// 保存图片
//				String filepath = "d:/google"+System.currentTimeMillis()+".jpg";
//				ImageIO.write(bi, "jpg", new File(filepath));
//				Point point = MouseInfo.getPointerInfo().getLocation();
//				System.out.println(point);// 来打印当前鼠标的坐标，从而找到对的位置
//				String imageToBase64ByLocal = Base64Util.ImageToBase64ByLocal(filepath);
//				System.out.println(imageToBase64ByLocal);
//		return imageToBase64ByLocal;
		String getpic = getpic();
		return getpic;
	}
	
	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException, AWTException {
//		Desktop.getDesktop().browse(
//				new URL("http://www.gzcc.gov.cn/data/QueryService/FileInfoemationVerify.aspx?ziguiEN=DC&anhao=1111&xingming=1111&chanzhenghao=11111").toURI());
		ProcessBuilder proc = new ProcessBuilder("C:/Users/jhs/AppData/Roaming/360se6/Application/360se.exe",
				"http://www.gzcc.gov.cn/data/QueryService/FileInfoemationVerify.aspx?ziguiEN=DC&anhao=1111&xingming=1111&chanzhenghao=11111");
        proc.start();
		Robot robot = new Robot();
		robot.delay(10000);
		Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		int width = (int) d.getWidth();
		int height = (int) d.getHeight();
		// 最大化浏览器
		robot.keyRelease(KeyEvent.VK_F11);
		robot.delay(2000);
		robot.mouseWheel(5);
		robot.mouseMove(1060, 834);
		robot.mousePress(KeyEvent.BUTTON1_MASK);
		robot.mouseRelease(KeyEvent.BUTTON1_MASK);
		robot.delay(2000);
		Image image = robot.createScreenCapture(new Rectangle(0, 0, width,
				height));
		BufferedImage bi = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.createGraphics();
		g.drawImage(image, 0, 0, width, height, null);
		// 保存图片
		String filepath = "d:/google"+System.currentTimeMillis()+".jpg";
		ImageIO.write(bi, "jpg", new File(filepath));
		Point point = MouseInfo.getPointerInfo().getLocation();
		System.out.println(point);// 来打印当前鼠标的坐标，从而找到对的位置
		String imageToBase64ByLocal = Base64Util.ImageToBase64ByLocal(filepath);
		System.out.println(imageToBase64ByLocal);
	}
	
	private String getpic() throws MalformedURLException, IOException, URISyntaxException, AWTException{
//		Desktop.getDesktop().browse(
//				new URL("http://www.gzcc.gov.cn/data/QueryService/FileInfoemationVerify.aspx?ziguiEN=DC&anhao=1111&xingming=1111&chanzhenghao=11111").toURI());
		ProcessBuilder proc = new ProcessBuilder("C:/Users/jhs/AppData/Roaming/360se6/Application/360se.exe",
				"http://www.gzcc.gov.cn/data/QueryService/FileInfoemationVerify.aspx?ziguiEN=DC&anhao=1111&xingming=1111&chanzhenghao=11111");
        proc.start();

		Robot robot = new Robot();
		robot.delay(10000);
		Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		int width = (int) d.getWidth();
		int height = (int) d.getHeight();
		// 最大化浏览器
		robot.keyRelease(KeyEvent.VK_F11);
		robot.delay(2000);
		robot.mouseWheel(5);
		robot.mouseMove(1060, 834);
		robot.mousePress(KeyEvent.BUTTON1_MASK);
		robot.mouseRelease(KeyEvent.BUTTON1_MASK);
		robot.delay(2000);
		Image image = robot.createScreenCapture(new Rectangle(0, 0, width,
				height));
		BufferedImage bi = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.createGraphics();
		g.drawImage(image, 0, 0, width, height, null);
		// 保存图片
		String filepath = "d:/google"+System.currentTimeMillis()+".jpg";
		ImageIO.write(bi, "jpg", new File(filepath));
		Point point = MouseInfo.getPointerInfo().getLocation();
		System.out.println(point);// 来打印当前鼠标的坐标，从而找到对的位置
		String imageToBase64ByLocal = Base64Util.ImageToBase64ByLocal(filepath);
		System.out.println(imageToBase64ByLocal);
		return "";
	}
	
	 private  void browse3(String url) throws Exception {
	        String firefox = "C:/Users/jhs/AppData/Roaming/360se6/Application/360se.exe";
	        Map map = System.getenv();
	        for (Object key : map.keySet()) {
	            String value = (String) map.get(key);
	            if (value.contains("firefox.exe")) {
	                firefox = value;
	                break;
	            }
	        }
	        Runtime.getRuntime().exec(new String[]{firefox, url});
	    }

}
