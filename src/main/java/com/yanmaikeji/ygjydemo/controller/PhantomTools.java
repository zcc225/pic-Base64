package com.yanmaikeji.ygjydemo.controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.util.ResourceUtils;

/**
 * @Description:根据网页地址转换成图片
 * @Author: zhangchangchao 
 * @CreateDate: 2018年6月22日
 */
public class PhantomTools {
    private static String tempPath = "D:/temp/img";// 图片保存目录
    private static String BLANK = " ";
    // 下面内容可以在配置文件中配置
    private static String binPath = "C:/Users/jhs/Desktop/phantomjs-2.1.1-windows/bin/phantomjs.exe";// 插件引入地址
    private static String jsPath = "C:/Users/jhs/Desktop/rasterize.js";// js引入地址
    ///ygjydemo/src/main/resources/exelib/rasterize.js
//    private static String aaa = ResourceUtils.CLASSPATH_URL_PREFIX+"exelib/rasterize.js";
    
//    private static String binPath = ResourceUtils.CLASSPATH_URL_PREFIX+"exelib/phantomjs-2.1.1-windows/bin/phantomjs.exe";// 插件引入地址
//    private static String jsPath = ResourceUtils.CLASSPATH_URL_PREFIX+"exelib/rasterize.js";// js引入地址
    // 执行cmd命令
    public static String cmd(String imgagePath, String url) {
        return binPath + BLANK + jsPath + BLANK + url + BLANK + imgagePath;
    }
    //关闭命令
    public static void close(Process process, BufferedReader bufferedReader) throws IOException {
        if (bufferedReader != null) {
            bufferedReader.close();
        }
        if (process != null) {
            process.destroy();
            process = null;
        }
    }
    /**
     * @param userId 
     * @param url
     * @throws IOException 
     */
    public static String printUrlScreen2jpg(String url) throws IOException{
        String imgagePath = tempPath+"/"+System.currentTimeMillis()+".png";//图片路径
        //Java中使用Runtime和Process类运行外部程序
        Process process = Runtime.getRuntime().exec(cmd(imgagePath,url));
        InputStream inputStream = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String tmp = "";
        while ((tmp = reader.readLine()) != null) {
            close(process,reader);
        }
        System.out.println("success");
        return imgagePath;
    }
    
    public static void main(String[] args) throws IOException {
        String url = "http://www.gzcc.gov.cn/data/QueryService/FileInfoemationVerify.aspx?ziguiEN=DC&anhao=1111&xingming=1111&chanzhenghao=11111";//以百度网站首页为例
        PhantomTools.printUrlScreen2jpg(url);
    }
}