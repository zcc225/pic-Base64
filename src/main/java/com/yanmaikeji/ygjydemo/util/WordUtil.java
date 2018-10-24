package com.yanmaikeji.ygjydemo.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.rtf.RtfWriter2;
 
 
 
public class WordUtil {
 private static Document document;
 private static BaseFont baseFont;
 
//创建word，并设置纸张文档
 
 private static void openWordFile(String fileName) throws DocumentException,
   IOException{
  document = new Document(PageSize.A4);
  RtfWriter2.getInstance(document,new FileOutputStream(fileName));
  document.open();
  baseFont =BaseFont.createFont();
 }
 
//设置标题
 
 private static boolean setTitle(String title) throws DocumentException {
  Font font = new Font(baseFont,4, Font.BOLD);
  Paragraph pTitle = new Paragraph(title + "\n");
  pTitle.setFont(font);
  pTitle.setAlignment(Element.ALIGN_CENTER);
 
  return document.add(pTitle);
 
 }
 
//设置文档内容
 
 private static boolean setContent(String content) throws DocumentException {
  Font font = new Font(baseFont,999, Font.NORMAL);
  Paragraph pContent = new Paragraph(content);
  pContent.setFont(font);
  pContent.setAlignment(Element.ALIGN_LEFT);
  pContent.setSpacingAfter(5);
  pContent.setFirstLineIndent(20);
  
  System.out.println(pContent);
  return document.add(pContent);
 }
 
//对外使用的接口
 
 public static boolean CreateWordFile(String url, String title,
   List<String> contents) {
  boolean returnValue =false;
  try {
   openWordFile(url);
   returnValue =setTitle(title);
   for (int i =0; i < contents.size(); i++) {
    returnValue= returnValue && setContent(contents.get(i));
   }
   document.close();
  } catch (DocumentException e){
   // TODOAuto-generated catch block
   e.printStackTrace();
  } catch (IOException e) {
   // TODOAuto-generated catch block
   e.printStackTrace();
  }
 
  return returnValue;
 
 }
 //对外使用的接口
 public static boolean CreateWordFile(String url,String title,
   String content) {
  boolean returnValue =false;
  try {
   openWordFile(url);
   returnValue =setTitle(title);
   returnValue =returnValue && setContent(content);
   document.close();
  } catch (DocumentException e){
   // TODOAuto-generated catch block
   e.printStackTrace();
  } catch (IOException e) {
   // TODOAuto-generated catch block
   e.printStackTrace();
  }
 
  return returnValue;
 
 }
 
public static void main(String[]args ) {
  WordUtil wordUtil = new WordUtil();
  List strList = new ArrayList();
 
//传入内容为字符串
  wordUtil.CreateWordFile("e:\\word.doc","标题居中", "我爱Java");
 
//传入内容为字符串List
  //wordUtil.CreateWordFile("e:\\word.doc","标题居中", strList);
 }
}