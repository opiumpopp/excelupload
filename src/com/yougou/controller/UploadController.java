package com.yougou.controller;

import java.io.InputStream;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.yougou.util.ImageUtil;

@Controller
public class UploadController {
	@RequestMapping("upload")
	public String hello(MultipartFile file) throws Exception {
		InputStream is = file.getInputStream();
		HSSFWorkbook hssf = new HSSFWorkbook(is);
		HSSFSheet sheet = hssf.getSheetAt(0);
		HSSFRow row1 = sheet.getRow(1);
		String insideCode = row1.getCell(4).toString();
		ImageUtil.copyImage(insideCode);
		int num = sheet.getLastRowNum();
		for(int i = 1; i <= num;i++) {
			HSSFRow row2 = sheet.getRow(i);
			String imageName = row2.getCell(5).toString();
			ImageUtil.copyImage(insideCode, imageName);
		}
		System.out.println("图片已经复制到指定目录并且命名完成");
		return "result";
	}
}
