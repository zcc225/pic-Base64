package com.yanmaikeji.ygjydemo.util;

import java.io.File;
import java.util.ArrayList;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

public class ZipUtil {

	/**
	 * 创建zip文件
	    * @Title: createZipFile
	    * @Description: TODO(这里用一句话描述这个方法的作用)
	    * @param     参数
	    * @return void    返回类型
	    * @throws
	 */
	public static void compressFile(String zipPath,String zipPassword,ArrayList<File> files){
		try {  
	           final ZipFile zipFile = new ZipFile(zipPath); // 創建zip包，指定了zip路徑和zip名稱  "f:\\test\\testZip.zip"
//	           final ArrayList<File> fileAddZip = new ArrayList<File>(); // 向zip包中添加文件集合  
//	           fileAddZip.add(new File("f:\\test\\yangjinhua.doc")); // 向zip包中添加一个word文件  "f:\\test\\yangjinhua.doc"
	           final ZipParameters parameters = new ZipParameters(); // 设置zip包的一些参数集合  
	           parameters.setEncryptFiles(true); // 是否设置密码（此处设置为：是）  
	           parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE); // 压缩方式(默认值)  
	           parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL); // 普通级别（参数很多）  
	           parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD); // 加密级别  
	  
	           parameters.setPassword(zipPassword); // 压缩包密码为 "123456" 
	           zipFile.createZipFile(files, parameters); // 创建压缩包完成  
//	           zipFile.setPassword(zipPassword);
	       } catch (final ZipException e) {  
	           // TODO Auto-generated catch block  
	           e.printStackTrace();  
	       } 
	}
	
	
	public static void unCompressFile(String unzipPath,String zipFilename,String zipPassword,String unCompressPath){
		try {  
	          final ZipFile zipFile = new ZipFile(unzipPath+File.separator+zipFilename); // 根据路径取得需要解压的Zip文件  "f:\\test\\testZip.zip"
	          if (zipFile.isEncrypted()) { // 判断文件是否加码  
	              zipFile.setPassword(zipPassword); // 密码为123456  "123456"
	          }  
	          zipFile.extractAll(unCompressPath); // 压缩包文件解压路径  "f:\\fffff\\"
	      } catch (final ZipException e) {  
	          // TODO Auto-generated catch block  
	          e.printStackTrace();  
	      }  
	} 
	
	public static void delZipFile(String zipPath,String zipFilename){
		try {  
	           final ZipFile zipFile = new ZipFile(zipPath+File.separator+zipFilename); // 根据路径取得需要解压的Zip文件  
	           // 删除压缩文件  
	           final File file = zipFile.getFile();  
	           if (file.exists()) { // 判断是否存在  
	               file.delete();  
	           }  
	       } catch (final ZipException e) {  
	           // TODO Auto-generated catch block  
	           e.printStackTrace();  
	       }  
	}
	
	
}
