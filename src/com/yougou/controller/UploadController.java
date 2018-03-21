package com.yougou.controller;

import java.io.File;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	@RequestMapping("upload")
	public String hello(MultipartFile file) throws Exception {
		String name = file.getOriginalFilename();
		System.out.println(name);
		return "";
	}
}
