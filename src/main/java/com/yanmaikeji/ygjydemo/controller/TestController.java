package com.yanmaikeji.ygjydemo.controller;

import java.awt.AWTException;
import java.awt.Desktop;
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
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yanmaikeji.ygjydemo.util.Base64Util;

@Controller
public class TestController {

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
