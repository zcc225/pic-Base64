package com.yanmaikeji.ygjydemo;

import java.io.File;
import java.util.ArrayList;

import com.yanmaikeji.ygjydemo.util.ZipUtil;

public class ZipTest {

//	public void Test(){
//		
//	}
	
	public static void main(String[] args) {
		ArrayList<File> files = new ArrayList<File>();
		files.add(new File("C:/Users/jhs/Desktop/aaaa.txt"));
		ZipUtil.compressFile("C:/Users/jhs/Desktop/testzip.zip", "123456", files);
		System.out.println("压缩完成");
	}
}
                                  