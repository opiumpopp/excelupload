package com.yougou.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 图片工具类
 * @author Orange丶Athena
 *
 */
public class ImageUtil {
	/**
	 * 随机拿到一张电脑自带的图片
	 */
	public static String getImageName(int no) {
		File file = new File("C:\\Users\\Public\\Pictures\\Sample Pictures");
		String[] arr = file.list();
		List<String> list = Arrays.asList(arr);
		/*
		 * 在使用Arrays.asList()后调用add，remove这些method时出现java.lang.UnsupportedOperationException异常。
		 * 这是由于Arrays.asList() 返回java.util.Arrays$ArrayList， 而不是ArrayList。
		 * Arrays$ArrayList和ArrayList都是继承AbstractList，
		 * remove，add等method在AbstractList中是默认throw UnsupportedOperationException而且不作任何操作。
		 * ArrayList override这些method来对list进行操作，但是Arrays$ArrayList没有override remove()，add()等，
		 * 所以throw UnsupportedOperationException。
		 */
		List<String> arrayList = new ArrayList<>(list);
		//移除desktop.ini这个隐藏文件
		arrayList.remove(2);
		Object[] array = arrayList.toArray();
		return array[no].toString();
	}
	
	/**
	 * 把拿到的图片移动到指定目录下
	 * @throws Exception 
	 */
	public static void copyImage(String insideCode, int no) throws Exception {
		String imageName = getImageName(no);
		File src = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\" + imageName);
		File dest = new File("E:\\image\\" + insideCode);
		if(!dest.exists()) {
			dest.mkdirs();
		}
		
		FileInputStream fis = new FileInputStream(src);
		FileOutputStream fos = new FileOutputStream(dest + "\\" + imageName);
		int len = 0;
		byte[] arr = new byte[1024 * 8];
		while((len = fis.read(arr)) != -1) {
			fos.write(arr, 0, len);
		}
		fis.close();
		fos.close();
		
		System.out.println("图片已移动到指定目录了");
	}
	
	/**
	 * 把图片复制并重命名到目标目录下
	 * @throws Exception 
	 */
	public static void copyImage(String insideCode,String newName, int no) throws Exception {
		String oldName = getImageName(no);
		File file1 = new File("E:\\image\\" + insideCode);
		File file2 = new File("E:\\image\\" + insideCode + "\\拍摄图\\");
		if(!file2.exists()) {
			file2.mkdirs();
		}
		
		FileInputStream fis = new FileInputStream(file1 + "\\" + oldName);
		FileOutputStream fos = new FileOutputStream(file2 + "\\" + newName + ".jpg");
		int len = 0;
		byte[] arr = new byte[1024 * 8];
		while((len = fis.read(arr)) != -1) {
			fos.write(arr, 0, len);
		}
		fis.close();
		fos.close();
	}
	
}
